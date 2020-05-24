package 两个数组的交集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution
{
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();

        Arrays.stream(nums1).boxed().forEach(integer -> {
            if (list2.contains(integer))
            {
                list2.remove(integer);
                res.add(integer);
            }
        });

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
