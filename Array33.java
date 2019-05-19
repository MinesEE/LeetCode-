// 33. Search in Rotated Sorted Array
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// 
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
// 
// You are given a target value to search. If found in the array return its index, otherwise return -1.
// 
// You may assume no duplicate exists in the array.
// 
// Your algorithm's runtime complexity must be in the order of O(log n).
// 
// Example 1:
// 
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
// 
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
class Array33 {
    public int search(int[] nums, int target) {
        if (nums.length <= 0) return -1;
        return helper(nums, target, 0, nums.length-1);
    }
    private int helper(int[] nums, int target, int left, int right) {
        if (right <= left + 1) {
            if (target == nums[left]) return left;
            else if (target == nums[right]) return right;
            else return -1;
        }
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) return mid;
        
        if (nums[mid] > nums[mid -1] && nums[mid] > nums[mid + 1]) {
            if (target > nums[mid]) return -1;
            else if (target >= nums[left]) {
                return helper(nums, target, left, mid -1);
            } else {
                return helper(nums, target, mid + 1, right);
            }
        } else if (nums[mid] < nums[mid -1] && nums[mid] < nums[mid + 1]) {
            if (target < nums[mid]) return -1;
            else if (target <= nums[right]) {
                return helper(nums, target, mid + 1, right);
            } else {
                return helper(nums, target, left, mid -1);
            }
        } else {
            if (nums[mid] < nums[right]) {
                if (target <= nums[right] && target > nums[mid]) {
                    return helper(nums, target, mid + 1, right);
                } else {
                    return helper(nums, target, left, mid -1);
                }
            } else {
                if (target>= nums[left] && target < nums[mid]) {
                    return helper(nums, target, left, mid -1);
                } else {
                    return helper(nums, target, mid + 1, right);
                }
            }
        }
    }
}