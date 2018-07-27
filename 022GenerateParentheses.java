/**
Given n pairs of parentheses, write a function to generate all 
combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
import java.util.*;
class 022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<String>();
    if (n <= 0) return res;
    StringBuilder sb = new StringBuilder();
     
    dfs(res, sb, n, n);
    return res;
    }
    private void dfs(List<String> res, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        
        int length = sb.length();
        if (left > 0) {
            sb.append('(');
            dfs(res, sb, left - 1, right);
            sb.setLength(length);
        }
        if (right > left) {
            sb.append(')');
            dfs(res, sb, left, right - 1);
            sb.setLength(length);
        }
    }
    public static void main(String[] args) {
        int n = 2;
        GenerateParentheses gp = new GenerateParentheses();
        List<String> result = gp.generateParenthesis(n);
        System.out.println(Arrays.toString(result.toArray()));
    }
}