package 岛屿的最大面积;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grad = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        Solution s = new Solution();
        System.out.println(s.maxAreaOfIsland(grad));
    }

    public int maxAreaOfIsland(int[][] grid) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res.add(dfs(grid, i, j));
            }
        }
        return Collections.max(res);
    }

    private int dfs(int[][] grid, int row, int col) {
        int rowL = grid.length;
        int colL = grid[0].length;
        int res = 0;

        if (grid[row][col] == 0) {
            return res;
        }
        res = 1;
        grid[row][col] = 0;

        if (row - 1 >= 0) {
            res = res + dfs(grid, row - 1, col);
        }
        if (row + 1 < rowL) {
            res = res + dfs(grid, row + 1, col);
        }
        if (col - 1 >= 0) {
            res = res + dfs(grid, row, col - 1);
        }
        if (col + 1 < colL) {
            res = res + dfs(grid, row, col + 1);
        }

        return res;
    }
}
