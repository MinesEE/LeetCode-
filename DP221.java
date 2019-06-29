// 221. Maximal Square
// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
// 
// Example:
// 
// Input: 
// 
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// 
// Output: 4
class DP221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j ==0) {
                    dp[i][j] = (int) matrix[i][j] - '0';
                } else {
                    if (matrix[i - 1][j] == '0' || matrix[i][j - 1] == '0' || matrix[i - 1][j - 1] == '0' || matrix[i][j] == '0') {
                        dp[i][j] = (int) matrix[i][j] - '0';
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i -1][j - 1]), dp[i][j -1]) + 1;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}