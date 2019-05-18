// 74. Search a 2D Matrix
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// 
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// Example 1:
// 
// Input:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 3
// Output: true
// Example 2:
// 
// Input:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 13
// Output: false
class Array72 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return helper(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }
    private boolean helper(int[][] matrix, int target, int left, int right) {
        if (left > right) return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int mid = left + (right - left) / 2;
        
        int curRow = mid / cols;
        int curCol = mid % cols;
        if (matrix[curRow][curCol] == target) {
            return true;
        } else if (matrix[curRow][curCol] < target) {
            return helper(matrix, target, mid + 1, right);
        } else {
            return helper(matrix, target, left, mid - 1);
        }
    }
}