// 24. Swap Nodes in Pairs
// *
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// Given a linked list, swap every two adjacent nodes and return its head.
// 
// You may not modify the values in the list's nodes, only nodes itself may be changed.
// 
//  
// 
// Example:
// 
// Given 1->2->3->4, you should return the list as 2->1->4->3.
class LinkedList24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        
        ListNode prev = dummy;
        ListNode cur = head;
        prev.next = cur;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next;
            prev.next = cur.next;
            prev.next.next = cur;
            cur.next = temp;
            
            cur = cur.next;
            prev = prev.next.next;
        }
        if (cur.next != null) {
            ListNode temp = cur.next;
            temp.next = cur;
            prev.next = temp;
            cur.next = null;
        }
        return dummy.next;
    }
}