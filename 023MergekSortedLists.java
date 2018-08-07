/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 * Suppose there are k lists with each size n.
 The time complexity is k*n log(k)
 */
 public class 023MergekSortedLists {
    private class ListNodeOrder implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }
//     private class ListNode {
//         int val;
//         ListNode next;
//         ListNode(int x) {
//             val = x;
//         }
//     }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ListNodeOrder());
        
        for (ListNode list:lists) {
            if (list != null) pq.offer(list);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }
 }