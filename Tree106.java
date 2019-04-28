// Given inorder and postorder traversal of a tree, construct the binary tree.
// 
// Note:
// You may assume that duplicates do not exist in the tree.
// 
// For example, given
// 
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
// Return the following binary tree:
// 
//     3
//    / \
//   9  20
//     /  \
//    15   7

class Tree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft > inorderRight) return null;
        TreeNode root = new TreeNode(postorder[postorderRight]);
        int pos = 0;
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == root.val) {
                pos = i;
                break;
            }
        }
        root.left = helper(inorder, postorder, inorderLeft, pos - 1, postorderLeft, postorderLeft + pos - inorderLeft - 1);
        root.right = helper(inorder, postorder, pos + 1, inorderRight, postorderRight - inorderRight + pos, postorderRight - 1);
        return root;
    }
}
