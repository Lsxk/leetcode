package 气球单词;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.containsKey(text.charAt(i)) ? map.get(text.charAt(i)) + 1 : 1);
        }

        int count = 0;

        while (map.getOrDefault('b', 0) >= 1
            && map.getOrDefault('a', 0) >= 1
            && map.getOrDefault('l', 0) >= 2
            && map.getOrDefault('o', 0) >= 2
            && map.getOrDefault('n', 0) >= 1) {

            count++;

            map.put('b', map.get('b') - 1);
            map.put('a', map.get('a') - 1);
            map.put('l', map.get('l') - 2);
            map.put('o', map.get('o') - 2);
            map.put('n', map.get('n') - 1);
        }

        return count;
    }
}
