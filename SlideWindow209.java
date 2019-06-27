// 209. Minimum Size Subarray Sum
// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
// 
// Example: 
// 
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.
// Follow up:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
class SlideWindow209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums.length == 0 || nums == null) return 0;
        
        int rst = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int p = 0;
        while (i < nums.length) {
            while (sum < s && i < nums.length) {
                sum += nums[i];
                i++;
            }
            
            if (sum < s && i - p == nums.length) return 0;
            
            while (sum >= s && p <= i - 1) {
                sum -= nums[p];
                p++;
                rst = Math.min(rst, i - p + 1);
            }
        }
        return rst;
    }
}