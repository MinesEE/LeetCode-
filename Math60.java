// 60. Permutation Sequence
// The set [1,2,3,...,n] contains a total of n! unique permutations.
// 
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
// 
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.
// 
// Note:
// 
// Given n will be between 1 and 9 inclusive.
// Given k will be between 1 and n! inclusive.
// Example 1:
// 
// Input: n = 3, k = 3
// Output: "213"
// Example 2:
// 
// Input: n = 4, k = 9
// Output: "2314"
class Math60 {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        helper(list, sb, k - 1);
        return sb.toString();
        
    }
    private void helper(List<Integer> list, StringBuilder sb, int k) {
        if (list.size() == 1) {
            sb.append(list.get(0));
            return;
        }
        
        int size = list.size() - 1;
        int re = k % factorial(size);
        
        sb.append(list.get(k / factorial(size)));
        list.remove(k / factorial(size));
        
        helper(list, sb, re);
            
    }
    
    private int factorial(int n) {
        int f = 1;
        while (n > 1) {
            f *= n;
            n -= 1; 
        }
        return f;
    }
}