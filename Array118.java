// 118. Pascal's Triangle
// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
// 
// 
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
// 
// Example:
// 
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
// Accepted
// 248,055
// Submissions
// 542,661

class Array118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (numRows <= 0) return res;
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        res.add(list);
        
        for (int i = 2; i <= numRows; i++) {
            list = new ArrayList<Integer>();
            list.add(1);
            List<Integer> temp = res.get(i - 2);
            for (int j = 1; j < temp.size(); j++) {
                list.add(temp.get(j) + temp.get(j-1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}