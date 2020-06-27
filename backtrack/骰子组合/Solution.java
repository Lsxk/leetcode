package 骰子组合;

/**
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 *
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 *
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回
 */
public class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if (target > d * f) {
            return 0;
        }
        return 0;

    }
}
