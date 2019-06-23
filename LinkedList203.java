// 203. Remove Linked List Elements
// Remove all elements from a linked list of integers that have value val.
// 
// Example:
// 
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
        
    }
}