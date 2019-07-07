// 45. Jump Game II
// Given an array of non-negative integers, you are initially positioned at the first index of the array.
// 
// Each element in the array represents your maximum jump length at that position.
// 
// Your goal is to reach the last index in the minimum number of jumps.
// 
// Example:
// 
// Input: [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2.
//     Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Note:
// 
// You can assume that you can always reach the last index.
class Greedy45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        
        int size = nums.length - 1;
        
        int count = 1;
        int max = 0;
        for (int i = 0; i <= size; i++) {
            if (nums[i] >= size - i) return count;
            int index = i + nums[i];
            count++;
            max = i + nums[i] + nums[i + nums[i]];
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j + nums[j] > max) {
                    max = j + nums[j];
                    index = j;
                }
            }
            i = index - 1;
        }
        return count;
    }
}