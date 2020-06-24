package 爱吃香蕉的珂珂;

import java.util.stream.IntStream;

/**
 * 功能描述：
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）
 * <p>
 * 寻找左边界的二分查找
 *
 * @version 1.0.0
 * @since 2020-06-20
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] ban = new int[] {3, 6, 7, 11};
        System.out.println(s.minEatingSpeed(ban, 8));

    }

    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = IntStream.of(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;

            if (canEated(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public boolean canEated(int[] piles, int speed, int k) {
        int count = 0;
        for (int p : piles) {
            count += (p - 1) / speed + 1;
        }
        return count <= k;
    }
}
