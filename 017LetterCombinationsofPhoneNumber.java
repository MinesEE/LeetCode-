/**
Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) 
is given below. Note that 1 does not map to any letters.

"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
2, 3, 4, 5, 6, 7, 8, 9

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, 
your answer could be in any order you want.
*/
import java.util.*;
public class 017LetterCombinationsofPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) return res;
        
        String[] telcode = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        
        dfs(res, telcode, sb, digits, sbLength);
        return res;
    }
    private void dfs(List<String> res, String[] telcode, StringBuilder sb, String digits, int sbLength) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = sbLength; i < digits.length(); i++) {
            int curDigit = digits.charAt(i) - '0';
            String curCode = telcode[curDigit];
            
            for (int j = 0; j < curCode.length(); j++) {
                int len = sb.length();
                sb.append(curCode.charAt(j));
                dfs(res, telcode, sb, digits, i + 1);
                sb.deleteCharAt(len);
            }
        }
    }
}
    