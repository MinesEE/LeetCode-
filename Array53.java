// 53. Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// 
// Example:
// 
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Follow up:
// 
// If you have figured out the O(n) solution, try coding another solution using the divide 
// and conquer approach, which is more subtle.
class Array53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int max = nums[0];
        int curMax = max;
        
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(curMax, max);
        }
        return max;
    }
}