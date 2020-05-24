package 罗马数字转整数;

public class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        s = s.replace("IV", "A")
            .replace("IX", "B")
            .replace("XL", "E")
            .replace("XC", "F")
            .replace("CD", "H")
            .replace("CM", "G");

        for (int i = 0; i < s.length(); i++) {
            ans += CHAR.valueOf(s.charAt(i) + "").value;
        }
        return ans;
    }

    enum CHAR {
        I(1),
        A(4),
        V(5),
        B(9),
        X(10),
        E(40),
        L(50),
        F(90),
        C(100),
        H(400),
        D(500),
        G(900),
        M(1000);

        private int value;

        CHAR(int value) {
            this.value = value;
        }
    }
}
