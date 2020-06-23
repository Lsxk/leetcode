package 字符串的排列;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 这个也是滑动窗口，但比较简单--->窗口大小固定
 *
 * @version 1.0.0
 * @since 2020-06-22
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            needs.put(c, needs.containsKey(c) ? needs.get(c) + 1 : 1);
        }

        int left = 0;
        int right = 0;

        int okNum = 0;

        while (right < s2.length()) {

            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.containsKey(c) ? window.get(c) + 1 : 1);
                if (window.get(c).equals(needs.get(c))) {
                    okNum++;
                }
            }

            while (right - left >= s1.length()) {
                if (okNum == needs.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        okNum--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;
    }
}
