package 生命游戏;

/**
 * 原地修改数组
 * <p>
 * 1.如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 2.如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 3.如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 4.如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //定义 -1：由死变活，2：由活变死
    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int aliveCount = calcAlive(i, j, board);
                if (board[i][j] == 1 && aliveCount < 2) {
                    board[i][j] = 2;
                    continue;
                }
                if (board[i][j] == 1 && (aliveCount == 2 || aliveCount == 3)) {
                    continue;
                }
                if (board[i][j] == 1 && aliveCount > 3) {
                    board[i][j] = 2;
                    continue;
                }
                if (board[i][j] == 0 && aliveCount == 3) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                    continue;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }

    }

    private int calcAlive(int row, int col, int[][] board) {
        int count = 0;
        if (check(row - 1, col - 1, board)) {
            count++;
        }

        if (check(row - 1, col, board)) {
            count++;
        }

        if (check(row - 1, col + 1, board)) {
            count++;
        }

        if (check(row, col - 1, board)) {
            count++;
        }

        if (check(row, col + 1, board)) {
            count++;
        }

        if (check(row + 1, col - 1, board)) {
            count++;
        }
        if (check(row + 1, col, board)) {
            count++;
        }
        if (check(row + 1, col + 1, board)) {
            count++;
        }

        return count;
    }

    private boolean check(int i, int j, int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || i >= rows) {
            return false;
        }
        if (j < 0 || j >= cols) {
            return false;
        }

        return board[i][j] >= 1;
    }
}
