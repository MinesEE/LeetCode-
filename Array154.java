// 154. Find Minimum in Rotated Sorted Array II
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// 
// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
// 
// Find the minimum element.
// 
// The array may contain duplicates.
// 
// Example 1:
// 
// Input: [1,3,5]
// Output: 1
// Example 2:
// 
// Input: [2,2,2,0,1]
// Output: 0
// Note:
// 
// This is a follow up problem to Find Minimum in Rotated Sorted Array.
// Would allow duplicates affect the run-time complexity? How and why?
class Array154 {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int lo, int hi) {
        if (hi <= lo + 1) return Math.min(nums[lo], nums[hi]);
        
        int mid = lo + (hi - lo) / 2;
        
        int midLeft = mid - 1;
        int midRight  = mid + 1;
        
        while (nums[mid] == nums[midRight] && midRight < hi) {
            midRight += 1; 
        }
        while (nums[mid] == nums[midLeft] && midLeft > lo) {
            midLeft -= 1;
        }
        if (nums[mid] == nums[midRight]) {
            return helper(nums, lo, mid);   
        }
        if (nums[mid] == nums[midLeft]) {
            return helper(nums, mid, hi);
        }
        if (nums[mid] < nums[midRight] && nums[mid] < nums[midLeft]) {
            return nums[mid];
        } else if (nums[mid] > nums[midRight] && nums[mid] > nums[midLeft]) {
            return nums[midRight];
        } else if (nums[mid] > nums[midRight] && nums[mid] < nums[midLeft]) {
            return helper(nums, midRight, hi);
        } else {
            if (nums[mid] < nums[hi]) {
                return helper(nums, lo, midLeft);
            } else {
                return helper(nums, midRight, hi); 
            }
        } 
    }
}