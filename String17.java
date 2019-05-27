// 17. Letter Combinations of a Phone Number
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
// 
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// 
// 
// 
// Example:
// 
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// 
// Although the above answer is in lexicographical order, your answer could be in any order you want.
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hash = builder();
        List<String> list = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) return list;
        StringBuilder sb = new StringBuilder();
        
        helper(list, sb, digits, hash, 0);
        return list;
        
        
    }
    
    private void helper(List<String> list, StringBuilder sb, String digits, HashMap<Character, String> hash, int start) {
        if (sb.length() == digits.length()) {
            list.add(new String(sb.toString()));
        }
        
        for (int i = start; i < digits.length(); i++) {
            String letters = hash.get(digits.charAt(start));
            for (int j = 0; j < letters.length(); j++) {
                sb.append(letters.charAt(j));
                helper(list, sb, digits, hash, i + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }
    
    private HashMap builder() {
        HashMap<Character, String> hash = new HashMap<Character, String>();
        hash.put('2', "abc");
        hash.put('3', "def");
        hash.put('4', "ghi");
        hash.put('5', "jkl");
        hash.put('6', "mno");
        hash.put('7', "pqrs");
        hash.put('8', "tuv");
        hash.put('9', "wxyz");
        return hash;
    }
}