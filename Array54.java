// 54. Spiral Matrix
// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
// 
// Example 1:
// 
// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:
// 
// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
class Array54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (matrix.length == 0 || matrix[0].length == 0) return list;
        
        helper(matrix, list, 0, matrix[0].length - 1, matrix.length - 1, 0);
        return list;
    }
    private void helper(int[][] matrix, List<Integer> list, int left, int right, int lo, int hi) {
        if (lo < hi || left > right) return;
        
        if (lo == hi || left == right) {
            if (lo == hi) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[hi][i]);
                }
            } else {
                for (int i = hi; i <= lo; i++) {
                    list.add(matrix[i][right]);
                }
            }
        } else {
            for (int i = left; i < right; i++) {
                list.add(matrix[hi][i]);
            }
            for (int i = hi; i < lo; i++) {
                list.add(matrix[i][right]);
            }
            for (int j = right; j > left; j--) {
                list.add(matrix[lo][j]);
            }
            for (int i = lo; i > hi; i--) {
                list.add(matrix[i][left]);
            }
        }
        helper(matrix, list, left + 1, right - 1, lo - 1, hi + 1);
    }
}