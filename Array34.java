// 34. Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
// 
// Your algorithm's runtime complexity must be in the order of O(log n).
// 
// If the target is not found in the array, return [-1, -1].
// 
// Example 1:
// 
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:
// 
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
class Array34 {
    public int[] searchRange(int[] nums, int target) {
        int[] index = new int[2];
        
        if (nums.length <= 1) {
            if (nums.length == 1 && nums[0] == target) {
                return index;
            } else {
                index[0] = -1;
                index[1] = -1;
                return index;
            }
        }
        
        int ind = helper(nums, target, 0, nums.length - 1);
        
        if (ind == -1) {
            index[0] = -1;
            index[1] = -1;
            return index;
        } else {
            index[0] = ind;
            index[1] = ind;
            int indLeft = helper(nums, target, 0, ind - 1);
            int indRight = helper(nums, target, ind + 1, nums.length - 1);
            while (indLeft != -1 || indRight != -1) {
                if (indLeft != -1) {
                    index[0] = indLeft;
                    indLeft = helper(nums, target, 0, indLeft - 1);
                }
                if (indRight != -1) {
                    index[1] = indRight;
                    indRight = helper(nums, target, indRight + 1, nums.length - 1);
                }
            }
            return index;
        }
    }
    
    private int helper(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) {
            return helper(nums, target, left, mid - 1);
        } else {
            return helper(nums, target, mid + 1, right);
        }
    }
}