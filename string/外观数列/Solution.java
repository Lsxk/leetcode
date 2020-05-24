package 外观数列;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 */
public class Solution
{
    public String countAndSay(int n) {
        if (n == 1)
        {
            return "1";
        }
        return nextNum(countAndSay( n -1));
    }

    String nextNum(String curNum) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < curNum.length(); i++)
        {
            if (i + 1 < curNum.length())
            {
                char curC = curNum.charAt(i);
                char nextC = curNum.charAt(i + 1);
                if (curC != nextC)
                {
                    sb.append(count);
                    sb.append(curC);
                    count = 1;
                }
                else
                {
                    count++;
                }
            }
            else
            {
                char last = curNum.charAt(i);
                if (curNum.length() > 1 && last != curNum.charAt(i - 1)) {
                    sb.append("1").append(last);
                }
                else
                {
                    sb.append(count).append(last);
                }
            }
        }
        return sb.toString();
    }
}
