package 最大数;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
 * <p>
 * <p>
 * 字典降序排列
 */
public class Solution {
    public String largestNumber(int[] nums) {

        List<String> collect = IntStream.of(nums).boxed().map(integer -> integer + "").sorted((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;

            return s2.compareTo(s1);
        }).collect(Collectors.toList());

        if (collect.get(0).equals("0")) {
            return "0";
        }

        return String.join("", collect);
    }
}
