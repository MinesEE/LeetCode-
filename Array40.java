// 40. Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
// 
// Each number in candidates may only be used once in the combination.
// 
// Note:
// 
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:
// 
// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
// Example 2:
// 
// Input: candidates = [2,5,2,1,2], target = 5,
// A solution set is:
// [
//   [1,2,2],
//   [5]
// ]
class Array40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > index && nums[i] == nums[i-1]){
                continue;
            }
            if (sum + nums[i] > target) break;
            sum += nums[i];
            template.add(nums[i]);
            helper(list, template, nums, target, sum, i+1);
            sum -= template.get(template.size() - 1);
            template.remove(template.size() - 1);
        }
    }
}