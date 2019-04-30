// 145. Binary Tree Postorder Traversal
// Given a binary tree, return the postorder traversal of its nodes' values.
// 
// Example:
// 
// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
// 
// Output: [3,2,1]
// Follow up: Recursive solution is trivial, could you do it iteratively?

class Tree145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        TreeNode ref = null;
        
        while (!stack.empty()) {
            TreeNode cur = stack.peek();
            TreeNode temp = null;
            if (cur.right == null || ref == cur.right) {
                temp = stack.pop();
                ref = temp;
                list.add(temp.val);
            } else {
                temp = cur.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return list;
    }
}