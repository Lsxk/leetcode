package 旋转数组;
public class Solution
{
    /**
     * 每次都把最后一个元素取出，前面元素往后移，循环k次
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++)
        {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--)
            {
                nums[j+1] = nums[j];
            }
            nums[0] = tmp;
        }
    }
}
