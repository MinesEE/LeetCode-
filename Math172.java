// 172. Factorial Trailing Zeroes
// Given an integer n, return the number of trailing zeroes in n!.
// 
// Example 1:
// 
// Input: 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.
// Example 2:
// 
// Input: 5
// Output: 1
// Explanation: 5! = 120, one trailing zero.
// Note: Your solution should be in logarithmic time complexity.
class Math172 {
    public int trailingZeroes(int n) {
        if (n <= 4) return 0;
        
        int count = 0;
        long p = 5; // to avoid overflow 
        while (n / p >= 1) {
            count += n / p;
            p *= 5;
        }
        return count;
    }
}