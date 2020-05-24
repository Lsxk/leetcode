package 整数反转;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class Solution
{
    public int reverse(int x) {
        String num = String.valueOf(Math.abs(x));
        String s = new StringBuffer(num).reverse().toString();
        try
        {
            int result = Integer.parseInt(s);
            if (x < 0) {
                return 0 - result;
            }
            else {
                return result;
            }
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}
