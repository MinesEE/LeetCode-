// 242. Valid Anagram
// Given two strings s and t , write a function to determine if t is an anagram of s.
// 
// Example 1:
// 
// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:
// 
// Input: s = "rat", t = "car"
// Output: false
// Note:
// You may assume the string contains only lowercase alphabets.
// 
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?
class String242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(s.charAt(i))) {
                hash.replace(s.charAt(i), hash.get(s.charAt(i)) + 1);
            } else {
                hash.put(s.charAt(i), 1);
            }
        }
        
        for (int j = 0; j < t.length(); j++) {
            if (!hash.containsKey(t.charAt(j))) {
                return false;
            } else {
                hash.replace(t.charAt(j), hash.get(t.charAt(j)) - 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) != 0) return false;
        }
        return true;
    }
}