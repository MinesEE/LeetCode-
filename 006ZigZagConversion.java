/**
The string "PAYPALISHIRING" is written in a zigzag pattern
on a given number of rows like this: (you may want to display
this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this 
conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/


/**
0. corner case is most important for this problem 
consider the following corner cases:
i) s = 'a', s = 'ab', s = 'abc', numRows = 1
ii) s = 'abc', numRows = 4
1. find patterns 
2. useful functions about StringBuilder
StringBuilder sb = new StringBuilder();
sb.append(a);
str = sb.toString();
*/
public class 006ZigZagConversion {
    public static String convert(String s, int numRows) {
    if (s == null || s.length() <= 1 || numRows == 1) {
    	return s;
    }
    if (s.length() < numRows) {
    	return s;
    }
    int j;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
    	j = 0;
    	sb.append(s.charAt((2 * numRows - 2) * j + i));
    	j++;
    	if (i == 0 || i == numRows - 1) {
    		while ((2 * numRows - 2) * j + i < s.length()) {
    			sb.append(s.charAt((2 * numRows - 2) * j + i));
    			j++;
    		}
    	} else {
    		while ((2 * numRows - 2) * j - i < s.length() || (2 * numRows - 2) * j + i < s.length()) {
    			if ((2 * numRows - 2) * j - i < s.length()) {
    				sb.append(s.charAt((2 * numRows - 2) * j - i));
    			}
    			if ((2 * numRows - 2) * j + i < s.length()) {
    				sb.append(s.charAt((2 * numRows - 2) * j + i));
    			}
    			j++;
    		}
    	}
    }
    return sb.toString();
	}
}