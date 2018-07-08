/**
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Assume we are dealing with an environment which could only
store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when 
the reversed integer overflows.
*/


/**
Idea: 
1. key is the way how we tell if the reverse of an integer 
will overflow. 
2. We can use x != 0 as a terminating condition instead of 
x / 10 != 0. This makes code neat.
*/
public class 007ReverseInteger {
	public static int reverse(int x) {
		int sum = 0;
		int cur;
		while (x != 0) {
			cur = sum;
			sum  = sum * 10 + x % 10;
			if (sum / 10 != cur) {
				return 0;
		    }
		    x = x / 10;
        }
	    return sum;
    }
}



// https://github.com/Blankj/awesome-java-leetcode
// Use long type 