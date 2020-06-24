package 无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 *
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;

        Set<Character> window = new HashSet<>();

        while (right < s.length()) {

            if (!window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                //收缩窗口
                window.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}