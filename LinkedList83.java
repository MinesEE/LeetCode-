// 83. Remove Duplicates from Sorted List
// Given a sorted linked list, delete all duplicates such that each element appear only once.
// 
// Example 1:
// 
// Input: 1->1->2
// Output: 1->2
// Example 2:
// 
// Input: 1->1->2->3->3
// Output: 1->2->3
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode p = head;
        
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}