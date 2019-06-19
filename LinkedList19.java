// 19. Remove Nth Node From End of List
// Given a linked list, remove the n-th node from the end of list and return its head.
// 
// Example:
// 
// Given linked list: 1->2->3->4->5, and n = 2.
// 
// After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// 
// Given n will always be valid.
// 
// Follow up:
// 
// Could you do this in one pass?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        return dummy.next;
        
    }
}