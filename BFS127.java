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
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        
        if (!wordList.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<String>();
        findWord(queue, beginWord, wordList);
        
        int n = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                wordList.remove(word);
                if (word.equals(endWord)) {
                    return n;
                } else {
                   findWord(queue, word, wordList); 
                }
            }
            n++;
        }
        return 0;  
    }
    
    private void findWord(Queue<String> queue, String word, List<String> wordList) {
        // Given a word, find all of possible nearby word from the wordList and 
        // put them into a List.
        for (int i = 0; i < wordList.size(); i++) {
            if (ifNearby(word, wordList.get(i))) {
                queue.add(wordList.get(i));
                // wordList.remove(i);
            }
        }
    }
    
    private boolean ifNearby(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (count > 1) return false;
            if (word1.charAt(i) != word2.charAt(i)) count++;
        }
        return count == 1;
    }
}