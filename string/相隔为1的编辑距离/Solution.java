package 相隔为1的编辑距离;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();
        if (len1 > len2) {
            return isOneEditDistance(t, s);
        }

        if (len2 - len1 > 1) {
            return false;
        }
        // t的长度长


        for (int i = 0; i < len1; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (len1 == len2) {
                    return s.substring(i + 1, len1).equals(t.substring(i + 1, len1));
                } else {
                    return s.substring(i, len1).equals(t.substring(i + 1, len2));
                }
            }
        }

        return len1 == len2 - 1;

    }

}
