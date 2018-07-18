/**
Given a string containing just the characters '(', ')', '{', '}', 
'[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/
import java.util.*;

/**
Idea: 
1. Use stack data structure 
2. Consider corner case like ']'. Thus we need to check if the stack is empty or not.
*/
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
               if (!stack.empty() && stack.peek() == '(') {
                   stack.pop();
               } else {
                   return false;
               }
            }
            if (s.charAt(i) == ']') {
               if (!stack.empty() && stack.peek() == '[') {
                   stack.pop();
               } else {
                   return false;
               }
            }
            if (s.charAt(i) == '}') {
               if (!stack.empty() && stack.peek() == '{') {
                   stack.pop();
               } else {
                   return false;
               }
            }
        }
        return stack.empty();
    }
}