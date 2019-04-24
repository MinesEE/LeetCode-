// 94. Binary Tree Inorder Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Tree94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                root = temp.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        return list;
    }
}