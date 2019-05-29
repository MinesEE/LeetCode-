// 38. Count and Say
// The count-and-say sequence is the sequence of integers with the first five terms as following:
// 
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// 
// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
// 
// Note: Each term of the sequence of integers will be represented as a string.
// 
//  
// 
// Example 1:
// 
// Input: 1
// Output: "1"
// Example 2:
// 
// Input: 4
// Output: "1211"

class String38 {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        if (n == 2) return "11";
        
        String temp = "11";
        for (int i = 3; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < temp.length()) {
                int count = 1;
                int ind = j;
                while (j < temp.length() - 1 && temp.charAt(j) == temp.charAt(j + 1)) {
                    count++;
                    j++;
                }
                
                sb.append(Character.forDigit(count, 10));
                sb.append(temp.charAt(ind));
                j++;
            }
            temp = sb.toString();
        }
        return temp;
    }
}