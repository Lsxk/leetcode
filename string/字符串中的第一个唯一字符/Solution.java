package 字符串中的第一个唯一字符;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 */
public class Solution
{
    public int firstUniqChar(String s) {
        Map<Character, CharNum> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new CharNum(i, 1));
            }
            else
            {
                map.get(c).count++;
            }
        }

        Optional<Map.Entry<Character, CharNum>> first = map.entrySet().stream().filter(c -> {
            if (c.getValue().count == 1)
            {
                return true;
            }
            return false;
        }).min(Comparator.comparingInt(value -> value.getValue().firstIndex));

        return first.map(characterCharNumEntry -> characterCharNumEntry.getValue().firstIndex).orElse(-1);
    }

    class CharNum {
        private int firstIndex;
        private int count;

        CharNum(int firstIndex, int count)
        {
            this.firstIndex = firstIndex;
            this.count = count;
        }
    }
}
