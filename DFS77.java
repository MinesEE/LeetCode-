// 77. Combinations
// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
// 
// Example:
// 
// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class DFS77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if (k <= 0 || n <= 0) return list;
        
        dfs(list, new ArrayList<Integer>(), n, k, 1);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> sublist, int n, int k, int start) {
        if (sublist.size() == k) {
            list.add(new ArrayList(sublist));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            sublist.add(i);
            dfs(list, sublist, n, k, i + 1);
            sublist.remove(sublist.size() - 1);
        }
    } 
}