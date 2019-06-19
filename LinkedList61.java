// 61. Rotate List
// Given a linked list, rotate the list to the right by k places, where k is non-negative.
// 
// Example 1:
// 
// Input: 1->2->3->4->5->NULL, k = 2
// Output: 4->5->1->2->3->NULL
// Explanation:
// rotate 1 steps to the right: 5->1->2->3->4->NULL
// rotate 2 steps to the right: 4->5->1->2->3->NULL
// Example 2:
// 
// Input: 0->1->2->NULL, k = 4
// Output: 2->0->1->NULL
// Explanation:
// rotate 1 steps to the right: 2->0->1->NULL
// rotate 2 steps to the right: 1->2->0->NULL
// rotate 3 steps to the right: 0->1->2->NULL
// rotate 4 steps to the right: 2->0->1->NULL
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        int size = 1;
        ListNode p = head;
        
        while (p.next != null) {
            p = p.next;
            size++;
        }
        k = k % size;
        p = head;
        for (int i = 1; i < size - k; i++) {
            p = p.next;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode p2 = dummy;
        dummy.next = head;
        while (p.next != null) {
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = p2.next;
            p2.next = temp;
            p2 = p2.next;
        }
        return dummy.next;
    }
}