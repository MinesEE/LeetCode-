// 16. 3Sum Closest
// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
// 
// Example:
// 
// Given array nums = [-1, 2, 1, -4], and target = 1.
// 
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

class Array16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        
        if (res == target) {
            return res;
        }
        
        Arrays.sort(nums);
        
        int diff = res - target;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right] - target;
                if (Math.abs(sum) < Math.abs(diff)) {
                    res = sum + target;
                    diff = sum;
                    if (sum == 0) {
                        return res;
                    } else {
                        if (diff > 0) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}