// 12. Integer to Roman
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// 
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
// 
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
// 
// Example 1:
// 
// Input: 3
// Output: "III"
// Example 2:
// 
// Input: 4
// Output: "IV"
// Example 3:
// 
// Input: 9
// Output: "IX"
// Example 4:
// 
// Input: 58
// Output: "LVIII"
// Explanation: L = 50, V = 5, III = 3.
// Example 5:
// 
// Input: 1994
// Output: "MCMXCIV"
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

class String12 {
        public String intToRoman(int num) {
        if (num <= 0) return "";
        
        int re = 0;
        int de = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            re = num % 10;
            num = num / 10;
            helper(sb, de, re);
            de += 1;
        }
        return sb.toString();
        
    }
    
    public void helper(StringBuilder sb, int num, int re) {
        if (num == 0) sbuilder(sb, re, 'I', 'V', 'X');
        if (num == 1) sbuilder(sb, re, 'X', 'L', 'C');
        if (num == 2) sbuilder(sb, re, 'C', 'D', 'M'); 
        if (num == 3) {
            if (re == 1) {
                sb.insert(0, "M");
            }
            else if (re == 2) {
                sb.insert(0, 'M');
                sb.insert(0, 'M');
            }
            else if (re == 3) {
                sb.insert(0, 'M');
                sb.insert(0, 'M');
                sb.insert(0, 'M');
            } else { return;}
        }
    }
    private void sbuilder(StringBuilder sb, int re, char c1, char c2, char c3){
        if (re == 0) return;
        else if (re <= 3) {
            for (int i = 1; i <= re; i++) {
                sb.insert(0, c1);
            }
            return;
        } else if (re == 4) {
            sb.insert(0, c2);
            sb.insert(0, c1);
            return; 
        } else if (re == 5) {
            sb.insert(0, c2);
            return;  
        } else if (re <= 8) {
            for (int i = 6; i <= re; i++) {
                sb.insert(0, c1);
            }
            sb.insert(0, c2);
            return;
        } else {
            sb.insert(0, c3);
            sb.insert(0, c1);
            return;
        }
    }
}