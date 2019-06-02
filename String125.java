// 125. Valid Palindrome
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
// 
// Note: For the purpose of this problem, we define empty string as valid palindrome.
// 
// Example 1:
// 
// Input: "A man, a plan, a canal: Panama"
// Output: true
// Example 2:
// 
// Input: "race a car"
// Output: false
class String125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left > right) return true;
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}