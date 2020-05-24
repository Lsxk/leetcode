package 环形数组循环;

/**
 * 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 *
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circular-array-loop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int slow = i;
            int fast = getNext(nums, i);

            int val = nums[i];

            while (val * nums[fast] > 0 & val * nums[getNext(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == getNext(nums, fast)) {
                        break;
                    }
                    return true;
                }
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
            }

            slow = i;
            while (val * nums[slow] > 0) {
                nums[slow] = 0;
                slow = getNext(nums, slow);
            }
        }
        return false;
    }

    int getNext(int[] nums, int i) {
       return ((nums[i] + i) % nums.length + nums.length) % nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {-1,-1,3};
        System.out.println(solution.circularArrayLoop(test));
    }
}
