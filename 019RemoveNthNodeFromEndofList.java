/**
Given a linked list, remove the n-th node from the end of 
list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
Got have to rewrite it at some point since it is easy and bug free at the first time.
*/
public class Solution {
        public 019ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode sentinel = new ListNode(-1);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel;
        
        sentinel.next = head;
        
        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return sentinel.next;
    }
}s