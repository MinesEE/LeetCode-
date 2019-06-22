// 79. Word Search
// Given a 2D board and a word, find if the word exists in the grid.
// 
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
// 
// Example:
// 
// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// 
// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
class DFS79 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        
        int rows = board.length;
        int cols = board[0].length;
        
        boolean res = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = dfs(board, word, i, j, 0);
                if (res) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int pos) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        if (word.charAt(pos) == board[r][c] && pos == word.length() - 1) {
            return true;
        }
        
        if (word.charAt(pos) != board[r][c]) return false;
        
        board[r][c] = '.';
        boolean rst = (
            dfs(board, word, r, c - 1, pos + 1) ||
            dfs(board, word, r, c + 1, pos + 1) ||
            dfs(board, word, r - 1, c, pos + 1) ||
            dfs(board, word, r + 1, c, pos + 1)
        );
        board[r][c] = word.charAt(pos);
        return rst;
    }
}