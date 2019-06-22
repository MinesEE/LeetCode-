// 109. Convert Sorted List to Binary Search Tree
// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
// 
// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
// 
// Example:
// 
// Given the sorted linked list: [-10,-3,0,5,9],
// 
// One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
// 
//       0
//      / \
//    -3   9
//    /   /
//  -10  5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Tree109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(temp.val);
        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(temp.next);
        return root;
    } 
}