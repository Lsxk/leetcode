package 矩阵中的路径;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int charIndex) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(charIndex)) {
            return false;
        }
        if (charIndex == word.length() - 1) {
            return true;
        }

        char c = board[i][j]; //c命中了
        board[i][j] = '/';
        boolean res = dfs(board, i + 1, j, word, charIndex + 1) || dfs(board, i - 1, j, word, charIndex + 1)
            || dfs(board, i, j + 1, word, charIndex + 1) || dfs(board, i, j - 1, word, charIndex + 1);
        board[i][j] = c;
        return res;
    }
}
