// 148. Sort List
// Sort a linked list in O(n log n) time using constant space complexity.
// 
// Example 1:
// 
// Input: 4->2->1->3
// Output: 1->2->3->4
// Example 2:
// 
// Input: -1->5->3->4->0
// Output: -1->0->3->4->5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode leftSide = sortList(dummy.next);
        ListNode rightSide = sortList(right);
        return merge(leftSide, rightSide);
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val < right.val) {
                    p.next = left;
                    left = left.next;
                } else {
                    p.next = right;
                    right = right.next;
                }
            } else if (left != null) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        return dummy.next;
        
    }
}