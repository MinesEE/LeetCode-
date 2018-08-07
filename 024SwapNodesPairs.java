/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 use dummy and use prev ListNode, starting from dummy 
 */
class 024SwapNodesPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev =dummy;
        
        while (head != null && head.next != null) {
            ListNode p = head;
            head = head.next;
            ListNode q = head.next;
            
            prev.next = head;
            head.next = p;
            p.next = q;
            head = head.next.next;
            prev = prev.next.next;
        }
        
        return dummy.next;
    }
}