package 从排序数组中删除重复项;

public class Solution
{
    public int removeDuplicates(int[] nums) {
        int num = 0;

        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[num] != nums[i + 1])
            {
                num++;
                nums[num] = nums[i + 1];
            }
        }


        return num + 1;
    }
}
