// 46. Permutations
// Given a collection of distinct integers, return all possible permutations.
// 
// Example:
// 
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
class DFS48 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        dfs(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> sublist, int[] nums, int index) {
        if (index > nums.length) return;
        if (index == nums.length) {
            list.add(new ArrayList<Integer>(sublist));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (sublist.contains(nums[i])) continue;
            else {
                sublist.add(nums[i]);
                dfs(list, sublist, nums, index + 1);
                sublist.remove(sublist.size() - 1);
            }
        }
    }
}