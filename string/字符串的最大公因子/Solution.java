package 字符串的最大公因子;

public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
            if (len1 % i == 0 && len2 % i == 0) {
                String X = str1.substring(0, i);
                if (check(str1, X) && check(str2, X)) {
                    return X;
                }
            }
        }
        return "";

    }

    //判断x是不是str的因子
    public boolean check(String str, String x) {
        int length = x.length();
        int index = 0;
        while (index + length <= str.length()) {
            if (!str.substring(index, index + length).equals(x)) {
                return false;
            }
            index = index + length;
        }

        return true;
    }
}
