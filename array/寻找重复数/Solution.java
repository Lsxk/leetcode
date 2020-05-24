package 寻找重复数;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    //循环检测，快慢指针 --> 类似检测链表有环
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        fast = nums[0];

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
