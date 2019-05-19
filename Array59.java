// 59. Spiral Matrix II
// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
// 
// Example:
// 
// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
class Array59 {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        if (n == 0) return m;
        
        if (n == 1) {
            m[0][0] = 1;
            return m;
        }
        return helper(m, 1, 0, m[0].length - 1, 0, m.length-1);
          
    }
    
    private int[][] helper(int[][] matrix, int n, int left, int right, int lo, int hi) {
        if (left > right || lo > hi) return matrix;
        
        if (left == right) {
            matrix[left][left] = n; // We need this, otherwise, it is not correct.
        } else {
            for (int i = left; i < right; i++) {
                matrix[lo][i] = n;
                n++;
            }
            for (int i = lo; i < hi; i++) {
                matrix[i][right] = n;
                n++;
            }
            for (int i = right; i > left; i--) {
                matrix[hi][i] = n;
                n++;
            }
            for (int i = hi; i > lo; i--) {
                matrix[i][left] = n;
                n++;
            }
        }
        
        return helper(matrix, n, left + 1, right -1 , lo + 1, hi-1);
    }
}