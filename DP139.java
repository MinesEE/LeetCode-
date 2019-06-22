// 139. Word Break
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
// 
// Note:
// 
// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.
// Example 1:
// 
// Input: s = "leetcode", wordDict = ["leet", "code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:
// 
// Input: s = "applepenapple", wordDict = ["apple", "pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//              Note that you are allowed to reuse a dictionary word.
// Example 3:
// 
// Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output: false
class DP139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        boolean[] rst = new boolean[size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (rst[j] == true) {
                    if (wordDict.contains(s.substring(j + 1, i + 1))) {
                        rst[i] = true;
                        break;
                    }
                } else {
                    continue;
                }
            }
            if (wordDict.contains(s.substring(0, i + 1))) {
                rst[i] = true;
            }
        }
        return rst[size - 1];  
    }
}