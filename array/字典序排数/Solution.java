package 字典序排数;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i + "");
        }

        res.sort((o1, o2) -> {
            int length1 = o1.length();
            int length2 = o2.length();

            for (int i = 0; i < Math.min(length1, length2); i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) - o2.charAt(i);
                }
            }

            return length1 - length2;
        });

        return res.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
