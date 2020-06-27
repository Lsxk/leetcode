package 顺时针打印二维数组;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;

        int left = 0;
        int right = columns - 1;

        int top = 0;
        int bottom = rows - 1;

        while (left <= right && top <= bottom) {
            //1.上部 (top, left) --> (top, right)
            for (int i = left; i <= right; i++) {
                order[index] = matrix[top][i];
                index++;
            }

            //2.右边 (top + 1, right) --> (bottom,right)
            for (int i = top + 1; i <= bottom; i++) {
                order[index] = matrix[i][right];
                index++;
            }
            if (left < right && top < bottom) {
                //3.下边 (bottom,right - 1) -> (bottom,left)
                for (int i = right - 1; i >= left; i--) {
                    order[index] = matrix[bottom][i];
                    index++;
                }

                //4.左边 (bottom -1,left) --> (top + 1,left)
                for (int i = bottom - 1; i >= top + 1; i--) {
                    order[index] = matrix[i][left];
                    index++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return order;
    }
}
