// 127. Word Ladder
// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
// 
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// Note:
// 
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// Example 1:
// 
// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]
// 
// Output: 5
// 
// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
// Example 2:
// 
// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]
// 
// Output: 0
// 
// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
class BFS127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if (wordList == null || wordList.size() == 0) return 0;
        if (!wordList.contains(endWord)) return 0;
        if(beginWord.equals(endWord)) return 2;
        
        HashSet<String> beginSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        wordList.remove(beginWord);
        wordList.remove(endWord);
        
        int n = 2;
        
        while (!beginSet.isEmpty()) {
            HashSet<String> nextLevel = new HashSet<String>();
            for (String word: beginSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        charArray[i] = j;
                        String str = String.valueOf(charArray);
                        if (endSet.contains(str)) return n;
                        
                        if (wordList.contains(str)) {
                            nextLevel.add(str);
                            wordList.remove(str);
                        }
                    }
                    charArray = word.toCharArray();
                }
            }
            n++;
            if (nextLevel.size() < endSet.size()) {
                beginSet = nextLevel;
            } else {
                beginSet = endSet;
                endSet = nextLevel;
            }
        }
        return 0;
    }
}