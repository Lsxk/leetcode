package Z字形变换;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> lines = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            lines.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false; // 第一次要自动转一下

        for (int i = 0; i < s.length(); i++) {

            lines.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            curRow += goingDown ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        lines.forEach(new Consumer<StringBuilder>() {
            @Override
            public void accept(StringBuilder builder) {
                sb.append(builder);
            }
        });

        return sb.toString();
    }
}
