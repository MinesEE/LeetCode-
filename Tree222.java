// 222. Count Complete Tree Nodes
// Given a complete binary tree, count the number of nodes.
// 
// Note:
// 
// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// 
// Example:
// 
// Input: 
//     1
//    / \
//   2   3
//  / \  /
// 4  5 6
// 
// Output: 6
class Tree222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null & root.right == null) return 1;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }
}