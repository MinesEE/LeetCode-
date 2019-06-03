// 47. Permutations II
// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
// 
// Example:
// 
// Input: [1,1,2]
// Output:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

// Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.

// Sort the array "int[] nums" to make sure we can skip the same value.

// when a number has the same value with its previous, we can use this number only if his previous is used
class DFS47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list  = new ArrayList<List<Integer>>();
        boolean[] index = new boolean[nums.length];
        
        Arrays.sort(nums);
        
        dfs(list, new ArrayList<Integer>(), nums, index);
        return list;
        
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> sublist, int[] nums, boolean[] index) {
        if (sublist.size() == nums.length) {
            list.add(new ArrayList(sublist));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (index[i]) continue;
            // The most import thing is here 
            else if (i > 0 && nums[i] == nums[i - 1] && !index[i - 1]) continue;
            else {
                sublist.add(nums[i]);
                index[i] = true;
                dfs(list, sublist, nums, index);
                index[i] = false;
                sublist.remove(sublist.size() - 1);
            }
        }
    }
}