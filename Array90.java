// 90. Subsets II
// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
// 
// Note: The solution set must not contain duplicate subsets.
// 
// Example:
// 
// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
class Array90 {   
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        helper(list, new ArrayList<Integer>(), nums, 0);
        return list;
        
    }
    private void helper(List<List<Integer>> list, List<Integer> subList, int[] nums, int start) {
        list.add(new ArrayList<Integer>(subList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            subList.add(nums[i]);
            helper(list, subList, nums, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}
}