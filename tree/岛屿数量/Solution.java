package 岛屿数量;

/**
 * 功能描述：
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围
 *
 *
 * @version 1.0.0
 * @since 2020-05-28
 */
public class Solution {
    public int numIslands(char[][] grid) {

        int res = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;

    }

    void dfs(char[][] grid, int row, int col) {

        int rowL = grid.length;
        int colL = grid[0].length;

        if (row >= rowL || row < 0 || col >= colL || col < 0 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
