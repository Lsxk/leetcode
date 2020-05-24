package 加一;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头
 */
public class Solution
{
    public int[] plusOne(int[] digits) {
        int[] tmp = new int[digits.length + 1];
        System.arraycopy(digits, 0, tmp, 1, digits.length);
        addOne(tmp, tmp.length - 1);

        if (tmp[0] != 0)
        {
            return tmp;
        }
        else
        {
            System.arraycopy(tmp, 1, digits, 0, digits.length);
            return digits;
        }
    }

    private void addOne(int[] nums, int index)
    {
        if (index < 0)
        {
            return;
        }

        int s = nums[index] + 1;
        if (s >= 10)
        {
            nums[index] = 0;
            addOne(nums, index - 1);
        }
        else
        {
            nums[index] = s;
        }
    }
}
