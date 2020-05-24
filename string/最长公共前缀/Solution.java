package 最长公共前缀;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class Solution
{
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
        {
            return "";
        }
        int minLength = Stream.of(strs).min(Comparator.comparingInt(String::length)).get().length();

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < minLength; i++)
        {
            boolean ok = true;
            for (int j = 0; j < strs.length - 1; j++)
            {
                if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                    ok = true;
                }
                else {
                    ok = false;
                    break;
                }
            }

            if (ok)
            {
                sb.append(strs[0].charAt(i));
            }
            else {
                break;
            }
        }

        return sb.toString();
    }
}
