/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// Iterative solution
class LinkedList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pt = head;
        while (pt.next != null) {
            ListNode temp = pt.next.next;
            pt.next.next = dummy.next;
            dummy.next = pt.next;
            pt.next = temp;
        }
        return dummy.next;
    }
}