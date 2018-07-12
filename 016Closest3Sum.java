/**
Given an array nums of n integers and an integer target, 
find three integers in nums such that the sum is closest to target. 
Return the sum of the three integers. You may assume that each input 
would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class 016Closest3Sum {
    public static int threeSumClosest(int[] nums, int target) {
        int res;
        Arrays.sort(nums);
        
        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (sum > target) {
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                } else {
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] num = new int[]{-1, 2, 1, -4};
        int tar = 1;
        int res = threeSumClosest(num, tar);
        System.out.println(res);
    }
}