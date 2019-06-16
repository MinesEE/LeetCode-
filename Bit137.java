// 137. Single Number II
// Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
// 
// Note:
// 
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
// 
// Example 1:
// 
// Input: [2,2,3,2]
// Output: 3
// Example 2:
// 
// Input: [0,1,0,1,0,1,99]
// Output: 99
class Bit137 {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
        }
        return b;
    }
}