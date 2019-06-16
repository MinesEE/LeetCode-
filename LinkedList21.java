// 21. Merge Two Sorted Lists
// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
// 
// Example:
// 
// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode tp = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tp = tp.next;
        }
        
        while (l1 != null) {
            tp.next = new ListNode(l1.val);
            l1 = l1.next;
            tp = tp.next;    
        }
        
        while (l2 != null) {
            tp.next = new ListNode(l2.val);
            l2 = l2.next;
            tp = tp.next;
        }
        
        return dummy.next;
        
    }
}