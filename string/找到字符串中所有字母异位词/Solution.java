package 找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 还是滑动窗口
 *
 * @version 1.0.0
 * @since 2020-06-22
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> anagrams = s.findAnagrams("baa", "aa");

        anagrams.forEach(System.out::println);
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();

        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            needs.put(c, needs.containsKey(c) ? needs.get(c) + 1 : 1);
        }

        int left = 0;
        int right = 0;
        int okNum = 0;

        List<Integer> ans = new ArrayList<>();

        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                window.put(c, window.containsKey(c) ? window.get(c) + 1 : 1);
                if (needs.get(c).equals(window.get(c))) {
                    okNum++;
                }
            }

            System.out.println(String.format("window: [%d, %d)\n", left, right));

            while (right - left >= p.length()) {
                if (needs.size() == okNum) {
                    ans.add(left);
                }

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
        return ans;

    }
}
