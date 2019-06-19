// 92. Reverse Linked List II
// Reverse a linked list from position m to n. Do it in one-pass.
// 
// Note: 1 ≤ m ≤ n ≤ length of list.
// 
// Example:
// 
// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode p1 = dummy.next;
        ListNode p2 = dummy;
        while (m - 1 > 0) {
            p1 = p1.next;
            p2 = p2.next;
            m--;
            n--;
        }
        
        while (n - 1 > 0) {
            ListNode temp = p1.next;
            p1.next = p1.next.next;
            temp.next = p2.next;
            p2.next = temp;
            n--;
        }
        return dummy.next;
    } 
}