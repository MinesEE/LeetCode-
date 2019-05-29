// 22. Generate Parentheses
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// 
// For example, given n = 3, a solution set is:
// 
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
class String22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        
        helper(list, new StringBuilder(), n, n);
        return list;
    }
    
    private void helper(List<String> list, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(sb.toString());
        }
        
        int length = sb.length();
        
        if (left > 0) {
            sb.append('(');
            helper(list, sb, left - 1, right);
            sb.setLength(length);
        }
        
        if (right > left) {
            sb.append(')');
            helper(list, sb, left, right - 1);
            sb.setLength(length);
        }
    }
}