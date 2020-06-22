package 排序矩阵查找;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return binarySearch(matrix, 0, matrix[0].length - 1, target);
    }

    public boolean binarySearch(int[][] matrix, int row, int col, int target) {
        if (row > matrix.length - 1 || col < 0) {
            return false;
        }
        int temp = matrix[row][col];

        if (temp == target) {
            return true;
        }

        if (temp > target) {
            return binarySearch(matrix, row, col - 1, target);
        } else {
            return binarySearch(matrix, row + 1, col, target);
        }

    }
}
