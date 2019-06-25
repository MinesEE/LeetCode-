// 216. Combination Sum III
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
// 
// Note:
// 
// All numbers will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:
// 
// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Example 2:
// 
// Input: k = 3, n = 9
// Output: [[1,2,6], [1,3,5], [2,3,4]]
class DFS216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n < k * (k +1) / 2 || k >= 10) return list;
        
        List<Integer> template = new ArrayList<Integer>();
        helper(list, template, k, n, 0, 1);
        return list;
    }
    private void helper(List<List<Integer>> list, List<Integer> template, int k, int n, int sum, int index) {
        if (template.size() > k) return;
        if (sum > n) return;
        if (sum == n && template.size() < k) return;
        if (sum < n && template.size() == k) return;
        
        if (template.size() == k && sum == n) {
            list.add(new ArrayList<Integer>(template));
            return;
        }
        
        
        for (int i = index; i <= 9; i++) {
            sum += i;
            template.add(i);
            helper(list, template, k, n, sum, i + 1);
            sum -= template.get(template.size() - 1);
            template.remove(template.size() - 1);
        }
    }
}