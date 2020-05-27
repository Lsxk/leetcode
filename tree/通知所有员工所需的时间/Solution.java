package 通知所有员工所需的时间;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) {
            return 0;
        }
        Set<Integer> res = new HashSet<>();
        numOfMinHelper(headID, manager, informTime, informTime[headID], res);
        return res.stream().max(Comparator.comparingInt(value -> value)).get();
    }

    public void numOfMinHelper(int curNum, int[] manager, int[] informTime, int time, Set<Integer> times) {
        List<Integer> subN = getSubN(curNum, manager);
        if (subN.isEmpty()) {
            times.add(time);
            return;
        }
        subN.forEach(integer -> numOfMinHelper(integer, manager, informTime, time + informTime[integer], times));
    }

    private List<Integer> getSubN(int curNum, int[] manager) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < manager.length; i++) {
            if (curNum == manager[i]) {
                res.add(i);
            }
        }

        return res;
    }
}
