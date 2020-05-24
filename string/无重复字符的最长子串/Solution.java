package 无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int res = 0;
        while (i < n & j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}