// 49. Group Anagrams
// Given an array of strings, group anagrams together.
// 
// Example:
// 
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:
// 
// All inputs will be in lowercase.
// The order of your output does not matter.
class String49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list  = new ArrayList<List<String>>();
        
        if (strs == null || strs.length == 0) return list;
        
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("$")) continue;
            else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (isAnagram(strs[i], strs[j])) {
                        temp.add(strs[j]);
                        strs[j] = "$";
                    } else continue;
                }
                list.add(temp);
            }
        }
        return list;
    }
    private boolean isAnagram(String s, String t) {
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