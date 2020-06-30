package 寻找两个正序数组的中位数;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 就是寻找第K小的数
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;

        int len2 = nums2.length;

        int sumLen = len1 + len2;
        if (sumLen % 2 == 1) {
            return findKNums(nums1, nums2, sumLen / 2 + 1);
        } else {
            int x = findKNums(nums1, nums2, sumLen / 2 + 1);
            int y = findKNums(nums1, nums2, sumLen / 2 + 2);

            return (double) (x + y) / 2;
        }
    }

    /**
     * 寻找第K小的数
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    int findKNums(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2) {
            return findKNums(nums2, nums1, k);
        }

        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }

        }
    }
}
