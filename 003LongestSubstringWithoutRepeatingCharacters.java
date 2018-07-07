/** 
Given a string, find the length of the longest 
substring without repeating characters.

Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/*
Idea:
1. use hash (key, value) = (character, position)
2. Consider corner cases like 'abba', the pointer should 
not point back
3. Even when we see repeated char, we still need to 
put new repeated char into HashMap
4. Another test case is "abba"
5. Essentially, every time, we are calculating the max 
size ending at index i as we scan i from 0 to s.length()
6. time complexity: O(n), space complexity: O(n)
*/

import java.util.*;
public class 003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	int pt = 0;
    	int max = 0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0; i < s.length(); i++) {
    		if (map.containsKey(s.charAt(i))) {
    			pt = Math.max(pt, map.get(s.charAt(i)) + 1);
    		}
    		map.put(s.charAt(i), i);
    		max = Math.max(max, i - pt + 1);
    	}
    	return max;
    }
}