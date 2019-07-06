/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 257. Binary Tree Paths 
// Given a binary tree, return all root-to-leaf paths.
// 
// Note: A leaf is a node with no children.
// 
// Example:
// 
// Input:
// 
//    1
//  /   \
// 2     3
//  \
//   5
// 
// Output: ["1->2->5", "1->3"]
// 
// Explanation: All root-to-leaf paths are: 1->2->5, 1->3
class Tree257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        
        if (root == null) return list;
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(root.val);
        
        dfs(list, sb, root);
        return list;
        
        
        
    }
    private void dfs(List<String> list, StringBuilder sb, TreeNode root) {
        if (root.left == null && root.right == null) {
            list.add(new String(sb));
            return;
        }
        
        int size = sb.length();
        if (root.left != null) {
            sb.append('-');
            sb.append('>');
            sb.append(root.left.val);
            dfs(list, sb, root.left);
            sb.setLength(size);
        }
        
        if (root.right != null) {
            sb.append('-');
            sb.append('>');
            sb.append(root.right.val);
            dfs(list, sb, root.right);
            sb.setLength(size);
        }
    }
}