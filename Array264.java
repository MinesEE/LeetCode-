// 264. Ugly Number II
// Write a program to find the n-th ugly number.
// 
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
// 
// Example:
// 
// Input: n = 10
// Output: 12
// Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
// Note:  
// 
// 1 is typically treated as an ugly number.
// n does not exceed 1690.

class Array264 {
    public int nthUglyNumber(int n) {
        if (n <= 1) return n;
        
        int[] rst = new int[n];
        rst[0] = 1;
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(rst[i2] * 2, rst[i3] * 3), rst[i5] * 5);
            rst[i] = min;
            if (min == (rst[i2] * 2)) i2++;
            if (min == (rst[i3] * 3)) i3++; //consider the case of 6
            if (min == (rst[i5] * 5)) i5++; // so we have to remove all possible cases
        }
        return rst[rst.length - 1];
    }
}