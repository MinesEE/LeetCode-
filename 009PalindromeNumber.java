/**
Determine whether an integer is a palindrome. 
An integer is a palindrome when it reads the same backward as forward.

Example 1:
Input: 121
Output: true

Example 2:
Input: -121
Output: false
Explanation: From left to right, it reads -121. 
From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: 10
Output: false
Explanation: Reads 01 from right to left. 
Therefore it is not a palindrome.

Follow up:
Coud you solve it without converting the integer to a string?
*/


/**
Idea: 
1. Consider the corner case: 0, 10, 100, 1000 
2. Apparently, single digit like 7 works
*/
class 009PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x > 0 && x % 10 == 0) return false;
        int sum = 0;
        while (sum < x) {
            sum = 10 * sum + x % 10;
            x = x / 10;
        }
        return (sum == x || sum / 10 == x);
    }
}


/** Another approach is to calculate its Palindrome explicitly */
class 009PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int x_copy = x; // Do not forget a copy 
        int reserve = 0;
        while (x != 0) {
            reserve = 10 * reserve + x % 10;
            x = x / 10;
        }
        return reserve == x_copy;
    }
}