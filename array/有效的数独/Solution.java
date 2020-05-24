package 有效的数独;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 */
public class Solution
{
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] cellCheck = new boolean[9][9];

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (board[i][j] >= '1' && board[i][j] <= '9')
                {
                    int num = board[i][j] - '1';

                    int cellNum = 3 * (i / 3) + (j / 3);

                    if (rowCheck[i][num] || colCheck[j][num] || cellCheck[cellNum][num])
                    {
                        return false;
                    }
                    else
                    {
                        rowCheck[i][num] = true;
                        colCheck[j][num] = true;
                        cellCheck[cellNum][num] = true;
                    }
                }

            }
        }
        return true;
    }
}