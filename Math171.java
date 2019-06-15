// 171. Excel Sheet Column Number
// Given a column title as appear in an Excel sheet, return its corresponding column number.
// 
// For example:
// 
//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...
// Example 1:
// 
// Input: "A"
// Output: 1
// Example 2:
// 
// Input: "AB"
// Output: 28
// Example 3:
// 
// Input: "ZY"
// Output: 701
class Math171 {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int res = 0;
        // HashMap<Character, Integer> hashMap = map();
        
        for (int i = 0; i < s.length(); i++) {
            res *= 26;
            // res += hashMap.get(s.charAt(i));
            res += (int) s.charAt(i) - 'A' + 1;
        }
        return res;
    }
    
//     private HashMap<Character, Integer> map() {
//         HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        
//         char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
//         for (int i = 1; i <= 26; i++) {
//             hashMap.put(Character.toUpperCase(alphabet[i - 1]), i);
//         }
//         return hashMap;
//     }
}