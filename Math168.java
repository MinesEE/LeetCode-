// 168. Excel Sheet Column Title
// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
// 
// For example:
// 
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
//     ...
// Example 1:
// 
// Input: 1
// Output: "A"
// Example 2:
// 
// Input: 28
// Output: "AB"
// Example 3:
// 
// Input: 701
// Output: "ZY"
class Math168 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        HashMap<Integer, Character> hashMap = map();
        while(n>0){
            n--;
            result.insert(0, hashMap.get(n % 26));
            n /= 26;
        }

        return result.toString();
    }
    
    private HashMap map() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<Integer, Character> hashMap = new HashMap<Integer, Character>();
        for (int i = 0; i <= 25; i++) {
            hashMap.put(i, Character.toUpperCase(alphabet[i]));
        }
        return hashMap;
    }
}