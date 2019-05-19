// 39. Combination Sum
// Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
// 
// The same repeated number may be chosen from candidates unlimited number of times.
// 
// Note:
// 
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:
// 
// Input: candidates = [2,3,6,7], target = 7,
// A solution set is:
// [
//   [7],
//   [2,2,3]
// ]
// Example 2:
// 
// Input: candidates = [2,3,5], target = 8,
// A solution set is:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]
class Array39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> template = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        int sum = 0;
        helper(list, template, candidates, target, sum, 0);
        return list;
    }
    
    private void helper(List<List<Integer>> list, List<Integer> template, int[] nums, int target, int sum, int index) {
        // if (sum > target) return;
        if (sum == target) {
            list.add(new ArrayList<Integer>(template));
        }
        
        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] > target) break;
            sum += nums[i];
            template.add(nums[i]);
            helper(list, template, nums, target, sum, i);
            sum -= template.get(template.size() - 1);
            template.remove(template.size() - 1);
        }
    }
}