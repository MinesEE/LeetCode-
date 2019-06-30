// 23. Merge k Sorted Lists
// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
// 
// Example:
// 
// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PriorityQueue23 {
    public class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode p1, ListNode p2) {
            if (p1.val < p2.val) return -1;
            if (p1.val > p2.val) return 1;
            return 0;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        if (lists.length == 1) return lists[0];
        
        Comparator<ListNode> comparator = new ListNodeComparator();
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, comparator);
        
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        for (ListNode n: lists) {
            if (n != null) {
                pq.offer(n);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            p.next = temp;
            p = p.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }
        
        return dummy.next;
        
    }
}