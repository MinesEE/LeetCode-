// 226. Invert Binary Tree
// Invert a binary tree.
// 
// Example:
// 
// Input:
// 
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// Output:
// 
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
// Trivia:
// This problem was inspired by this original tweet by Max Howell:
// 
// Google: 90% of our engineers use the software you wrote (Homebrew), 
// but you can’t invert a binary tree on a whiteboard so f*** off.
class Tree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null & root.right == null) return root;
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.right = leftTree;
        root.left = rightTree;
        return root;
    }
}