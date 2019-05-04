// 101. Symmetric Tree
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
// 
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
// 
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
//  
// 
// But the following [1,2,2,null,3,null,3] is not:
// 
//     1
//    / \
//   2   2
//    \   \
//    3    3
//  
// 
// Note:
// Bonus points if you could solve it both recursively and iteratively.

class Tree101 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) {
            return helper(p.left, q.right) && helper(p.right, q.left);
        } else {
            return false;
        }
    }
}