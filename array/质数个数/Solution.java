package 质数个数;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class Solution {


    public int countPrimes(int n) {
        int count = 0;
        if (n < 2) {
            return 0;
        }

        for (int i = 2; i < n; i++) {

            int sqrt = (int) Math.sqrt(i);
            boolean bool = true;

            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    bool = false;
                    break;
                }
            }

            if (bool) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }
}
