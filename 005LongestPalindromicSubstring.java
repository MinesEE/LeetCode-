/**Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer. 

Example 2:
Input: "cbbd"
Output: "bb"
*/

/**
Idea:
1. Given an arbitrary index i, just consider two cases
above. And use two pointers to check if left and right 
has the same char or not. 
2. Remember to break out of while loop if 
s.charAt(left) == s.charAt(right) does not hold.
*/
public class 005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	if (s == null || s.length() == 0) return s;
    	String res = new String();
    	int left;
    	int right;
    	for (int i = 0; i < s.length(); i++) {
    		left = i - 1;
    		right = i + 1;
    		while (right < s.length() && s.charAt(right) == s.charAt(i)) {
    			right++;
    		}
    		while (left >= 0 && right < s.length()) {
    			if (s.charAt(left) == s.charAt(right)) {
    				left--;
    				right++;
    			} else {
    				break;
    			}
    		}
    		String cur = s.substring(left+1, right);
    		if (cur.length() > res.length()) {
    			res = cur;
    		}
    	} 
    	return res;
    }
}

// DP solution 