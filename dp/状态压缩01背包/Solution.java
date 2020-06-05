package 状态压缩01背包;

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();

        int[] w = new int[n];
        for (int i = 0; i < n; i++)
        {
            w[i] = sc.nextInt();
        }
        sc.close();

        DP dp = new DP(n, c1, c2, w);
        System.out.println(dp.dp());
    }

    static class DP{

        int n;

        int c1;

        int c2;

        int[] w;   //物品体积

        int[] dp;  //记录状态为index的最小搬运次数,value为次数

        int[] ok;  //记录所有的可一次搬运完状态，value为状态

        DP(int n, int c1, int c2, int[] w)
        {
            this.n = n;
            this.c1 = c1;
            this.c2 = c2;
            this.w = w;
            int count = 0;
            dp = new int[1 << n];
            ok = new int[1 << n];

            int[] v = new int[c1 + 1];
            for (int i = 0; i < (1 << n); i++)
            {
                dp[i] = n + 1;

                if (check(i, v))
                {
                    ok[count++] = i;
                }
            }

        }


        /**
         * 判断X状态能否一次完成
         * @param x 状态x
         * @param v c1箱子能搬运状态为index的最大体积
         * @return boolean
         */
        boolean check(int x, int[] v)
        {
            int sum = 0 ;
            for(int i=0; i<=c1; ++i)
            {
                v[i] = 0;
            }
            v[0] = 1;
            for(int i = 0; i < n; ++i)
            {
                if(((x >> i) & 1) != 0) //有第i件物品
                {
                    sum += w[i];
                    for(int j = c1; j >= w[i]; --j)
                    {
                        v[j] = Math.max(v[j], v[j - w[i]] + w[i]);
                    }
                }
            }
            if(sum > c1 + c2)
            {
                return false;
            }
            return sum - v[c1] <= c2;
        }

        int dp()
        {
            dp[0] = 0;
            for (int i = 0; i < ok.length; i++)
            {
                for (int j = dp.length - 1; j >= 0 ; j--)
                {
                    if ((ok[i] & j) == 0) // 不冲突，每一位不能重复出现
                    {
                        dp[j | ok[i]] = Math.min(dp[j | ok[i]], dp[j] + 1);
                    }
                }
            }
            return dp[dp.length - 1];
        }
    }
}
