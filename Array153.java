// 153. Find Minimum in Rotated Sorted Array
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// 
// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
// 
// Find the minimum element.
// 
// You may assume no duplicate exists in the array.
// 
// Example 1:
// 
// Input: [3,4,5,1,2] 
// Output: 1
// Example 2:
// 
// Input: [4,5,6,7,0,1,2]
// Output: 0
class Array153 {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int lo, int hi) {
        if (hi <= lo + 1) return Math.min(nums[lo], nums[hi]);
        
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < nums[mid +1] && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        } else if (nums[mid] > nums[mid +1] && nums[mid] > nums[mid - 1]) {
            return nums[mid + 1];
        } else if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
            return helper(nums, mid + 1, hi);
        } else {
            if (nums[mid] < nums[hi]) {
                return helper(nums, lo, mid - 1);
            } else {
                return helper(nums, mid + 1, hi); 
            }
        }   
    }
}