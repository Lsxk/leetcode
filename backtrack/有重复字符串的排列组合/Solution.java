package 有重复字符串的排列组合;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(res, S.length(), 0, new StringBuilder(), new boolean[S.length()], S);
        res = res.stream().distinct().collect(Collectors.toList());

        return res.toArray(new String[res.size()]);
    }

    public void backtrack(List<String> res, int length, int depth, StringBuilder temp, boolean[] visited, String s) {
        if (depth == length) {
            res.add(temp.toString());
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                temp.append(s.charAt(i));
                visited[i] = true;
                backtrack(res, length, depth + 1, temp, visited, s);
                temp.deleteCharAt(temp.length() - 1);
                visited[i] = false;
            }
        }
    }
}
