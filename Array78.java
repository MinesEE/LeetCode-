// 78. Subsets
// Given a set of distinct integers, nums, return all possible subsets (the power set).
// 
// Note: The solution set must not contain duplicate subsets.
// 
// Example:
// 
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
class Array78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        helper(list, new ArrayList<Integer>(), nums, 0);
        return list;
        
    }
    private void helper(List<List<Integer>> list, List<Integer> subList, int[] nums, int start) {
        list.add(new ArrayList<Integer>(subList));
        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            helper(list, subList, nums, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}