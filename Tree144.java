// 144. Binary Tree Preorder Traversal
// Given a binary tree, return the preorder traversal of its nodes' values.
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
// Output: [1,2,3]
// Follow up: Recursive solution is trivial, could you do it iteratively?

class Tree144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null) {
            list.add(root.val);
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                temp = temp.right;
                while (temp != null) {
                    list.add(temp.val);
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return  list;
    }
}