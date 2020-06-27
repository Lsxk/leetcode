package n的第k个因子;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);

                if (list.size() == k) {
                    return i;
                }
            }
        }

        return -1;
    }
}
