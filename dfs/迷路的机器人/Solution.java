package 迷路的机器人;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，
 * 但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 */
public class Solution {

    int row;

    int col;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        row = obstacleGrid.length;
        col = obstacleGrid[0].length;
        dfs(obstacleGrid, res, 0, 0, new boolean[row][col]);
        return res;
    }

    public boolean dfs(int[][] grid, List<List<Integer>> res, int i, int j, boolean[][] visited) {
        if (i > row || j > col || visited[i][j] || grid[i][j] == 1) {
            return false;
        }

        res.add(Arrays.asList(i, j));
        if (i == row - 1 && j == col - 1) {
            return true;
        }

        visited[i][j] = true;

        if (dfs(grid, res, i + 1, j, visited) || dfs(grid, res, i, j + 1, visited)) {
            return true;
        }

        res.remove(res.size() - 1);
        return false;

    }
}
