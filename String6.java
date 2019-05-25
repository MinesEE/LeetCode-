// 6. ZigZag Conversion
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
// 
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// 
// Write the code that will take a string and make this conversion given a number of rows:
// 
// string convert(string s, int numRows);
// Example 1:
// 
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// Example 2:
// 
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// 
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
class String6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        
        if (numRows == 1) return s;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int k = 0;
            if (i == 0 || i == numRows - 1) {
                while ( (2 * numRows - 2) * k + i < s.length() ) {
                    sb.append(s.charAt((2 * numRows - 2) * k + i));
                    k++;
                } 
            } else {
                while ((2 * numRows - 2) * k - i < s.length() || (2 * numRows - 2) * k + i < s.length()) {
                    if ((2 * numRows - 2) * k + i < s.length()) {
                        sb.append(s.charAt((2 * numRows - 2) * k + i));
                    } 
                    k++;
                    if ((2 * numRows - 2) * k - i > 0 && (2 * numRows - 2) * k - i < s.length()) {
                        sb.append(s.charAt((2 * numRows - 2) * k - i));
                    }
                }
            }
        }
        return sb.toString();
    }
}