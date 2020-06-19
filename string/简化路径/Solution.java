package 简化路径;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (temp.length() > 0) {
                    if (temp.toString().equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }

                    } else if (!temp.toString().equals(".")) {
                        stack.push(temp.toString());
                    }
                    temp = new StringBuilder();
                }

            } else {
                temp.append(c);
            }

            if (i == path.length() - 1) {
                if (temp.length() > 0) {
                    if (temp.toString().equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }

                    } else if (!temp.toString().equals(".")) {
                        stack.push(temp.toString());
                    }
                    temp = new StringBuilder();
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        List<String> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        for (int i = ans.size() - 1; i >= 0; i--) {
            builder.append("/");
            builder.append(ans.get(i));
        }

        return builder.length() > 0 ? builder.toString() : builder.append("/").toString();
    }
}
