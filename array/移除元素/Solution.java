package 移除元素;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int lastIndex = nums.length - 1;

        int count = 0;

        while (index <= lastIndex) {
            if (nums[index] == val) {
                for (int i = index; i < lastIndex; i++) {
                    nums[i] = nums[i + 1];
                }

                lastIndex--;
                count++;
            } else {
                index++;
            }
        }

        return nums.length - count;
    }
}
