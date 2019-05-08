// 152. Maximum Product Subarray
// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
// 
// Example 1:
// 
// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:
// 
// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
class Array152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int max = nums[0];
        int curMax = max;
        int curMin = max;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMin;
            curMin = Math.min(curMin * nums[i], curMax * nums[i]);
            curMin = Math.min(curMin, nums[i]);
            
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMax = Math.max(temp * nums[i], curMax);
            max = Math.max(max, curMax);
        }
        return max;
    }
}