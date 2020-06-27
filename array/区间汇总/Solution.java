package 区间汇总;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        int left = 0;
        int right = 0;
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }

        while (right < nums.length - 1) {
            right++;
            if (nums[right] != nums[right - 1] + 1) {
                //add res

                if (left == right - 1) {
                    ans.add(nums[left] + "");
                } else {
                    ans.add(nums[left] + "->" + nums[right - 1]);
                }

                left = right;
            }
        }
        if (left == right) {
            ans.add(nums[left] + "");
        } else {
            ans.add(nums[left] + "->" + nums[right]);
        }

        return ans;
    }
}
