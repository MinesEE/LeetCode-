// 7. Reverse Integer
// Given a 32-bit signed integer, reverse digits of an integer.
// 
// Example 1:
// 
// Input: 123
// Output: 321
// Example 2:
// 
// Input: -123
// Output: -321
// Example 3:
// 
// Input: 120
// Output: 21
// Note:
// Assume we are dealing with an environment 
// which could only store integers within the 32-bit signed 
// integer range: [−231,  231 − 1]. For the purpose of this problem, 
// assume that your function returns 0 when the reversed integer overflows.
class Math7 {
    public int reverse(int x) {
        int sum = 0;
        int number = 0;
        
        while (x != 0) {
            number = sum * 10 + x % 10;
            if (number / 10 != sum) return 0;
            else {
                sum = number;
                x /= 10;
            }
        }
        return sum;
    }
}