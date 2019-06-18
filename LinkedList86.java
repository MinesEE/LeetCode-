// 86. Partition List
// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// 
// You should preserve the original relative order of the nodes in each of the two partitions.
// 
// Example:
// 
// Input: head = 1->4->3->2->5->2, x = 3
// Output: 1->2->2->4->3->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedList86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = dummy2;
        dummy2.next = head;
        
        ListNode p1 = dummy1;
        ListNode p3 = dummy2;
        ListNode p2 = head;
        
        while (p2 != null) {
            if (p2.val < x) {
                p3.next = p2.next;
                p2.next = dummy2;
                p1.next = p2;
                
                p1 = p1.next;
                p2 = p3.next;
            } else {
                p2 = p2.next;
                p3 = p3.next;
            }
        }
        p1.next = p1.next.next;
        return dummy1.next;
        
    }
}