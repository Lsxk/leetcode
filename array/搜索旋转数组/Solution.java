package 搜索旋转数组;

/**
 * 功能描述：
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，
 * 假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 *
 * 此题和旋转一次的区别是：旋转一次，必定有一半是有序的
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {

    int ans = Integer.MAX_VALUE;

    public int search(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else {
                if (arr[left] < arr[mid]) {
                    // 左边有序
                    if (target >= arr[left] && target < arr[mid]) {
                        // 在左边
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                else if (arr[left] > arr[mid]) {
                    //为啥右边有序？
                    if (arr[mid] > target) {
                        //右边不可能有了
                        right = mid - 1;
                    }
                    else if (arr[left] < target) {
                        left = mid - 1;
                    }
                    else {
                        if (arr[left] == target) {
                            ans = Math.min(ans, left);
                            break;
                        }
                        else {
                            left = mid + 1;
                        }
                    }


                }
                else {
                    left = left + 1;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
