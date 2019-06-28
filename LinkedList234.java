// 234. Palindrome Linked List
// Given a singly linked list, determine if it is a palindrome.
// 
// Example 1:
// 
// Input: 1->2
// Output: false
// Example 2:
// 
// Input: 1->2->2->1
// Output: true
// Follow up:
// Could you do it in O(n) time and O(1) space?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode p = head;
        int n = 1;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while (fast.next != null && fast.next.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (n % 2 != 0) {
            slow = slow.next;
        }
        
        ListNode p1 = slow.next;
        
        while (p1.next != null) {
            ListNode temp = p1.next;
            p1.next = p1.next.next;
            temp.next = slow.next;
            slow.next = temp;
        } 
        
        fast = dummy;
        while (slow.next != null) {
            if (slow.next.val != fast.next.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true; 
    }
}