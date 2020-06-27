package 去掉最低工资和最高工资后的工资平均值;

public class Solution {
    public double average(int[] salary) {
        int min = salary[0];
        int max = 0;
        int sum = 0;

        for (int i1 : salary) {
            sum += i1;
            min = Math.min(min, i1);
            max = Math.max(max, i1);
        }

        return (double) (sum - min - max) / (salary.length - 2);
    }
}
