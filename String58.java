// 58. Length of Last Word
// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
// 
// If the last word does not exist, return 0.
// 
// Note: A word is defined as a character sequence consists of non-space characters only.
// 
// Example:
// 
// Input: "Hello World"
// Output: 5
class String58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int m = s.length();
        
        while (m >= 1) {
            if (s.charAt(m - 1) == ' ') m--;
            else break;
        }
        
        
        int index = -1;
        for (int i = m - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                index = i;
                break;
            }   
        }
        return  m - 1 - index;
    }
}