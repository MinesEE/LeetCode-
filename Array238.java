// 238. Product of Array Except Self
// Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
// 
// Example:
// 
// Input:  [1,2,3,4]
// Output: [24,12,8,6]
// Note: Please solve it without division and in O(n).
// 
// Follow up:
// Could you solve it with constant space complexity? 
// (The output array does not count as extra space for the purpose of space complexity analysis.)
// 思路： 这道题目很巧，先是从右边到昨天算cumulative的乘积，存到结果的array上，然后
// 再从左到又扫一遍的时候算cumulative的乘积，然后顺便算结果。结果就是index左边的乘积
// 乘以右边的第一个pass已经存的右边的乘积。
class Array238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        
        int size = nums.length;
        int[] rst = new int[size];
        
        rst[size - 1] = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rst[i] = rst[i + 1] * nums[i];
        }
        
        rst[0] = rst[1];
        for (int i = 1; i < size - 1; i++) {
            nums[i] = nums[i - 1] * nums[i];
            rst[i] = rst[i + 1] * nums[i - 1];
        }
        rst[size - 1] = nums[size - 2];
        return rst;
    }
}