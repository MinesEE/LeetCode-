// 30. Substring with Concatenation of All Words
// You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
// 
// Example 1:
// 
// Input:
//   s = "barfoothefoobarman",
//   words = ["foo","bar"]
// Output: [0,9]
// Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
// The output order does not matter, returning [9,0] is fine too.
// Example 2:
// 
// Input:
//   s = "wordgoodgoodgoodbestword",
//   words = ["word","good","best","word"]
// Output: []
class String30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words == null || words.length == 0) return list;
        
        int m = words.length;
        int n = words[0].length();
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        
        for (int i = 0; i <= s.length() - m * n; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            
            int k = m; 
            int j = i;
            while (k > 0) {
                String temp = s.substring(j, j + n);
                if (!copy.containsKey(temp) || copy.get(temp) <= 0) {
                    break;
                } else {
                    copy.put(temp, copy.get(temp) - 1);
                }
                k--;
                j += n;
            }
            if (k == 0) list.add(i);
        }
        return list;
    }
}