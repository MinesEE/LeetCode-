// 82. Remove Duplicates from Sorted List II
// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
// 
// Example 1:
// 
// Input: 1->2->3->3->4->4->5
// Output: 1->2->5
// Example 2:
// 
// Input: 1->1->1->2->3
// Output: 2->3
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode p1 = dummy;
        ListNode p2 = head;
        
        while (p1.next != null) {
            if (p2.next != null && p2.next.val == p2.val) {
                while (p2.next != null && p2.next.val == p2.val) {
                    p2 = p2.next;
                }
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return dummy.next;
    }
}