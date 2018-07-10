/**
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters 
as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or 
minus sign followed by as many numerical digits as possible, and 
interprets them as a numerical value.

The string can contain additional characters after those that 
form the integral number, which are ignored and have no effect 
on the behavior of this function.

If the first sequence of non-whitespace characters in str is 
not a valid integral number, or if no such sequence exists 
because either str is empty or it contains only whitespace 
characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:
1. Only the space character ' ' is considered as whitespace character.
2. Assume we are dealing with an environment which could only store 
integers within the 32-bit signed integer range: [−231,  231 − 1]. 
If the numerical value is out of the range of representable values, 
INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example 1:

Input: "42"
Output: 42


*/ 

/** My lengthy and possibly wrong approach... */
import java.util.*;
public class 008StringtoIntegerAtoi {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0 || str == " " || str == "+" || str == "-") return 0;
        HashSet<Character> set = new HashSet<Character>();
        String num = "0123456789";
        for (int i = 0; i < num.length(); i++) {
            set.add(num.charAt(i));
        }
        int left = 0;
        int right = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == ' ') {
                continue;
            } 
            if (str.charAt(j) != '+' && str.charAt(j) != '-' && !set.contains(str.charAt(j))) return 0;
            if (str.charAt(j) == '+' || str.charAt(j) == '-') {
                left = j;
                right = j+1;
                while (right < str.length()) {
                    if (set.contains(str.charAt(right))) {
                        right++;
                    } else {
                        if (!set.contains(str.charAt(right)) && right - left == 1) {
                            return 0;
                        }
                        break;
                    }
                }
            }
            if (set.contains(str.charAt(j))) {
                left = j;
                right = j+1;
                while (right < str.length() && set.contains(str.charAt(right))) {
                    right++;
                }
            }
            break;
        }
        String s_sub = str.substring(left, right);
        if (s_sub.length() >= 12) {
            if (s_sub.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            long res = Long.parseLong(s_sub);
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) res;
            }
        }
    }
    public static void main(String[] args) {
        String s = " ";
        System.out.println(s.trim());
    }
}

/** Approach from leetcode 
1. we can use trim to get rid of ' ' space characters 
2. we can use Character.isDigit to see if 'x' x is a digit or not
3. if it is a digit, we can extract the number in 'x' by 'x' - '0'.
*/
public class 008StringtoIntegerAtoi {
    public static int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        
        int sign = 1;
        double sum = 0;
        int pt = 0;
        
        if (str.charAt(0) == '-') {
            sign = -1;
            pt++;
        } else if (str.charAt(0) == '+') {
            pt++;
        }
        while (pt < str.length() && Character.isDigit(str.charAt(pt))) {
            sum = 10 * sum + (str.charAt(pt) - '0');
            pt++;
        }
        sum = sign * sum;
        if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sum < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) sum;
        }
    }
}