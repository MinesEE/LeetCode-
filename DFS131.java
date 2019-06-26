// 131. Palindrome Partitioning
// Given a string s, partition s such that every substring of the partition is a palindrome.
// 
// Return all possible palindrome partitioning of s.
// 
// Example:
// 
// Input: "aab"
// Output:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]
class DFS131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return list;
        
        List<String> template = new ArrayList<String>();
        dfs(list, template, s, 0);
        return list;
        
    }
    private void dfs(List<List<String>> list, List<String> template, String s, int index) {
        if (index == s.length()) {
            list.add(new ArrayList<String>(template));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (!isPalindrome(str)) continue;
            template.add(str);
            dfs(list, template, s, i + 1);
            template.remove(template.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}