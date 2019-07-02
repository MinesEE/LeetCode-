// 41. First Missing Positive
// Given an unsorted integer array, find the smallest missing positive integer.
// 
// Example 1:
// 
// Input: [1,2,0]
// Output: 3
// Example 2:
// 
// Input: [3,4,-1,1]
// Output: 2
// Example 3:
// 
// Input: [7,8,9,11,12]
// Output: 1
// Note:
// 
// Your algorithm should run in O(n) time and uses constant extra space.
class Array41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        if (nums.length == 1) {
            if (nums[0] == 1) return 2;
            else return 1;
        }
        
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            while (nums[i] <= size && nums[i] >= 1 && nums[nums[i] - 1] != nums[i]) {
                int index = nums[i] - 1;
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            } 
        }
                
        for (int i = 0; i < size; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return size + 1;
    }
}