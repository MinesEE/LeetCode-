// 29. Divide Two Integers
// Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
// 
// Return the quotient after dividing dividend by divisor.
// 
// The integer division should truncate toward zero.
// 
// Example 1:
// 
// Input: dividend = 10, divisor = 3
// Output: 3
// Example 2:
// 
// Input: dividend = 7, divisor = -3
// Output: -2
// Note:
// 
// Both dividend and divisor will be 32-bit signed integers.
// The divisor will never be 0.
// Assume we are dealing with an environment which could only 
// store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
// For the purpose of this problem, assume that your function returns 231 − 1 
// when the division result overflows.
class Math29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        int res = 0;
        
        int sign=(dividend<0)^(divisor<0)?-1:1;
        long did =Math.abs((long)dividend);
        long div =Math.abs((long)divisor);
        while (did >= div) {
            long temp = div;
            int m = 1;
            while (temp << 1  <= did) {
                temp = temp << 1;
                m = m << 1;
            }
            res += m;
            did -= temp;
        }
        return sign * res;
    }
}