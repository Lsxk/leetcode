package 移动零;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution
{
    /**
     * 双指针法
     * @param nums
     */
    public void moveZeroes(int[] nums)
    {

        int okIndex = nums.length - 1;
        int moveIndex = 0;

        while (moveIndex < okIndex)
        {
            if (nums[moveIndex] == 0)
            {
                for (int i = moveIndex; i < nums.length - 1; i++)
                {
                    nums[i] = nums[i + 1];
                }
                nums[nums.length - 1] = 0;
                okIndex--;

            }
            else
            {
                moveIndex++;
            }

        }
    }
}
