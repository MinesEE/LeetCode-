// 119. Pascal's Triangle II
// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
// 
// Note that the row index starts from 0.
// 
// Example:
// 
// Input: 3
// Output: [1,3,3,1]
// Follow up:
// 
// Could you optimize your algorithm to use only O(k) extra space?
class Array119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<Integer>();
        
        int[] res = new int[rowIndex+1];  
        res[0] = 1;
        
        for (int i = 1; i < rowIndex + 1; i++) {
            int prev = res[0];
            for (int j = 1; j < i; j++) {
                int cur = res[j];   //IMPORTANT
                res[j] = res[j] + prev;
                prev = cur;
            }
            res[i] = 1;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < res.length; i++) {
            list.add(res[i]);
        }
        return list;
    }
}