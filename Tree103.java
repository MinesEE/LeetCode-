// 103. Binary Tree Zigzag Level Order Traversal
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
// 
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]
class Tree103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int d = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                if (d % 2 == 1) {
                    temp.add(0, cur.val);
                } else {
                    temp.add(cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            d += 1;
            list.add(temp);
        }
        return list;
    }
}