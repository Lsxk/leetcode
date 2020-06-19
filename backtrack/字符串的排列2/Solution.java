package 字符串的排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述：
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(res, new StringBuilder(), new boolean[s.length()], chars);
        return res.toArray(new String[res.size()]);
    }

    public void backtrack(List<String> res, StringBuilder temp, boolean[] visited, char[] s) {
        if (temp.length() == s.length) {
            res.add(temp.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (visited[i]) {
                continue;
            }

            if(i > 0 && !visited[i-1] && s[i-1] == s[i]){
                continue;
            }

            visited[i] = true;
            temp.append(s[i]);
            backtrack(res, temp, visited, s);
            temp.deleteCharAt(temp.length() - 1);
            visited[i] = false;
        }
    }
}
