// 230. Kth Smallest Element in a BST
// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
// 
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
// 
// Example 1:
// 
// Input: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// Output: 1
// Example 2:
// 
// Input: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// Output: 3
// Follow up:
// What if the BST is modified (insert/delete operations) often and you 
// need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
class Tree230 {
public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        int kth = 0;
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            k -= 1;
            if (k == 0) {
                kth = temp.val;
                break;
            }
            if (temp.right != null) {
                temp = temp.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return kth;
    }
}