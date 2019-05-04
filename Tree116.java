// 116. Populating Next Right Pointers in Each Node
// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
// 
// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
// 
// Initially, all next pointers are set to NULL.
public class Tree116 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < queueSize; i++) {
                TreeLinkNode cur = queue.poll();
                if (prev != null) prev.next = cur;
                prev = cur;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        prev.next = null;
    }
}