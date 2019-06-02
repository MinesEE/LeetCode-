// 151. Reverse Words in a String
// Given an input string, reverse the string word by word.
// 
//  
// 
// Example 1:
// 
// Input: "the sky is blue"
// Output: "blue is sky the"
// Example 2:
// 
// Input: "  hello world!  "
// Output: "world! hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:
// 
// Input: "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//  
// 
// Note:
// 
// A word is defined as a sequence of non-space characters.
// Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
// You need to reduce multiple spaces between two words to a single space in the reversed string.
//  
// 
// Follow up:
// 
// For C programmers, try to solve it in-place in O(1) extra space.
class String151 {
    public String reverseWords(String s) {
        if (s == null) return s;
        
        s = s.trim();
        
        if (s.length() <= 1) return s;
        
        char[] c = s.toCharArray();
        
        reserve(c, 0, c.length - 1);
        
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                right = i - 1;
                reserve(c, left, right);
                for (int j = left; j <= right; j++) {
                    sb.append(c[j]);
                }
                sb.append(' ');
                left = i;
            }
            while (i < c.length && c[i] == ' ') {
                i++;
                left++;
            }
        }
        reserve(c, left, c.length - 1);
        for (int j = left; j < c.length; j++) {
            sb.append(c[j]);
        }
        return sb.toString();
        
    }
    
    private void reserve(char[] s, int left, int right) {
        // reserve string s from left to right
        
        while (right >= left) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}