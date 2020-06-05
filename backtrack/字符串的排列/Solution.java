package 字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] abcs = solution.permutation("abc");
        System.out.println(abcs);
    }

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        boolean[] visit = new boolean[s.length()];
        backtrack(s, res, new ArrayList<>(), visit);
        String[] re = new String[res.size()];
        res.toArray(re);
        return re;
    }

    public void backtrack(String s, List<String> res, List<Character> temp, boolean[] visit) {
        // 选择和选择列表
        for(int i = 0; i < s.length(); i++){
            // 排除不合法的选择
            if(visit[i]){
                continue;
            }

            if(i > 0 && !visit[i-1] && s.charAt(i-1) == s.charAt(i)){
                continue;
            }
            visit[i] = true;
            // 做选择
            temp.add(s.charAt(i));
            // 进入下一次决策树
            backtrack(s, res, temp, visit);
            // 撤销选择
            temp.remove(new Character(s.charAt(i)));
            visit[i] = false;
        }
    }
}
