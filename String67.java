//67. Add Binary
// Given two binary strings, return their sum (also a binary string).
// 
// The input strings are both non-empty and contains only characters 1 or 0.
// 
// Example 1:
// 
// Input: a = "11", b = "1"
// Output: "100"
// Example 2:
// 
// Input: a = "1010", b = "1011"
// Output: "10101"
class String67 {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            if (m >= 0 && n >= 0) {
                sum = (a.charAt(m) - '0') + (b.charAt(n) - '0') + sum;
                sb.insert(0, sum % 2);
                sum /= 2;
                m--;
                n--;
            } else if (m >= 0) {
                sum = (a.charAt(m) - '0') + sum;
                sb.insert(0, sum % 2);
                sum /= 2;
                m--;
            } else {
                sum = (b.charAt(n) - '0') + sum;
                sb.insert(0, sum % 2);
                sum /= 2;
                n--;
            }
        }
        if (sum == 1) sb.insert(0, 1);
        return sb.toString();
    }
}