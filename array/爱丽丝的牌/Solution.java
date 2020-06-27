package 爱丽丝的牌;

import java.util.TreeMap;

/**
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * <p>
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * <p>
 * 如果她可以完成分组就返回 true，否则返回 false。
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap();
        for (int card : hand) {
            if (!count.containsKey(card)) {
                count.put(card, 1);
            } else {
                count.replace(card, count.get(card) + 1);
            }
        }

        while (count.size() > 0) {
            int first = count.firstKey();
            for (int card = first; card < first + W; ++card) {
                if (!count.containsKey(card)) {
                    return false;
                }
                int c = count.get(card);
                if (c == 1) {
                    count.remove(card);
                } else {
                    count.replace(card, c - 1);
                }
            }
        }

        return true;
    }
}
