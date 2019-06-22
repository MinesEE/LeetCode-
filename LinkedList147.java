//147. Insertion Sort List
// Sort a linked list using insertion sort.
// 
// 
// A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
// With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
//  
// 
// Algorithm of Insertion Sort:
// 
// Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
// At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
// It repeats until no input elements remain.
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
class LinkedList147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = head.next;
        ListNode p2 = head;
        ListNode p3 = dummy;
        
        while (p1 != null) {
            if (p1.val >= p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            }  else {
                ListNode temp = p1.next;
                while (p3.next.val < p1.val) {
                    p3 = p3.next;
                }
                p1.next = p3.next;
                p3.next = p1;
                
                p1 = temp;
                p2.next = temp;
                p3 = dummy;
            }
        }
        return dummy.next;
    }
}