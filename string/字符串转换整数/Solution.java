package 字符串转换整数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
public class Solution
{

    class Automaton {
        private HashMap<String, List<String>> table = new HashMap<String, List<String>>();

        public Automaton()
        {
            table.put("start", Arrays.asList("start", "signed", "in_num", "end"));
            table.put("signed", Arrays.asList("end", "end", "in_num", "end"));
            table.put("in_num", Arrays.asList("end", "end", "in_num", "end"));
            table.put("end", Arrays.asList("end", "end", "end", "end"));
        }



    }
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0)
        {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        char c = str.charAt(0);
        if (c == '+' | c == '-' || (c >= '0' && c <= '9'))
        {
            sb.append(c);

            for (int i = 1; i < str.length(); i++)
            {
                char c1 = str.charAt(i);
                if (c1 >= '0' && c1 <= '9')
                {
                    sb.append(c1);
                }
                else {
                    break;
                }
            }
        }
        else
        {
            return 0;
        }
        try
        {
            if (sb.length() == 1 && (sb.charAt(0) == '+' || sb.charAt(0) == '-'))
            {
                return 0;
            }
            return Integer.parseInt(sb.toString());
        }
        catch (Exception e)
        {
            if (sb.charAt(0) == '-')
            {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }
}
