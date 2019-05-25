// 5. Longest Palindromic Substring
// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
// 
// Example 1:
// 
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:
// 
// Input: "cbbd"
// Output: "bb"
class String5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        int maxLength = 1;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
            }
            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
            }
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else break;
            }
            if (right - left -1 > maxLength) {
                start = left + 1;
                maxLength = right - left - 1;
            }
            
        }
        return s.substring(start, start + maxLength);
    }
}