/**
You are given two non-empty linked lists representing two
non-negative integers. The digits are stored in reverse order 
and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, 
except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Idea:
1. use sentinel node.
2. use a node p to track where we are.
3. consider the case at last sum/10 != 0
4. do not forget l1 = l1.next and l2 = l2.next !!
*/


public class 002AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null) {
    		return l1;
    	}
    	
    	int sum = 0;
    	
    	ListNode sentinel = new ListNode(-1);
    	ListNode p = sentinel;
    	
    	while (l1 != null || l2 != null) {
    		if (l1 != null) {
    			sum += l1.val;
    			l1 = l1.next;  // do not miss 
    		}
    		if (l2 != null) {
    			sum += l2.val;
    			l2 = l2.next; // do not miss
    		}
    		
    		ListNode cur = new ListNode(sum % 10);
    		
    		sum /= 10;
    		
    		p.next = cur;
    		p = p.next;
    	}
    	if (sum != 0){
    		ListNode ad = new ListNode(sum);
    		p.next = ad;
    	}
    	return sentinel.next;
    }
}
