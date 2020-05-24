package 有效的字母异位词;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Solution
{
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
        {
            return false;
        }
        for (int i = 0; i < t.length(); i++)
        {
            s = s.replaceFirst("" + t.charAt(i), "");
        }
        return s.length() == 0;
    }
}
