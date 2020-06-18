package 最长不含重复字符的子字符串;

/**
 * 功能描述：
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 分析了一下dp行不通，主要原因是要判断有没有重复的字符，dp table没这种能力。
 * <p>
 * 用滑动窗口吧
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("a"));
    }
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if (s.length() <= 1) {
            return s.length();
        }

        int i = 0, j = 0;

        while (j < s.length() - 1) {
            if (!s.substring(i, j + 1).contains(s.charAt(j + 1) + "")) {
                j++;
                ans = Math.max(ans, j - i + 1);
            } else {
                i++;
            }
        }

        return ans;

    }
}
