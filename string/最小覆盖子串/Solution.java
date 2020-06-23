package 最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 典型滑动窗口
 *
 * @version 1.0.0
 * @since 2020-06-22
 */
public class Solution {

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            needs.put(c, needs.containsKey(c) ? needs.get(c) + 1 : 1);
        }

        int start = 0;
        int len = Integer.MAX_VALUE;

        int okNum = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                //更新窗口
                window.put(c, window.containsKey(c) ? window.get(c) + 1 : 1);

                if (window.get(c).equals(needs.get(c))) {
                    // 为什么要相等--->满足一个字符
                    okNum++;
                }
            }

            //判断窗口是否要收缩
            while (okNum == needs.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d删除，left向右滑动
                char d = s.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        okNum--;
                    }

                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
