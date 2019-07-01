// 32. Longest Valid Parentheses
// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
// 
// Example 1:
// 
// Input: "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()"
// Example 2:
// 
// Input: ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()"
class Stack32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int rst = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                rst = Math.max(rst, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return rst;
    }
}