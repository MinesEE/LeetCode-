// Given an integer n, generate all structurally unique BST's 
// (binary search trees) that store values 1 ... n.
// 
// Example:
// 
// Input: 3
// Output:
// [
//   [1,null,3,2],
//   [3,2,null,1],
//   [3,1,null,null,2],
//   [2,1,3],
//   [1,null,2,null,3]
// ]
// Explanation:
// The above output corresponds to the 5 unique BST's shown below:
// 
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3


class Tree95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);
            
            for (int leftptr = 0; leftptr < leftTree.size(); leftptr++) {
                for (int rightptr = 0; rightptr < rightTree.size(); rightptr++) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = leftTree.get(leftptr);
                    temp.right = rightTree.get(rightptr);
                    list.add(temp);
                }
            }
        }
        
        if (list.size() == 0) {
            list.add(null);
            return list;
        }
        return list;
    }
}





