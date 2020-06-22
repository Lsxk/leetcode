package 行星碰撞;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        for (int n : asteroids) {
            if (n > 0) {
                stack.push(n);
            } else {
                if (stack.empty()) {
                    res.add(n);
                } else {
                    while (n != 0 && !stack.empty()) {
                        if (Math.abs(n) > stack.peek()) {
                            stack.pop();
                        } else if (Math.abs(n) == stack.peek()) {
                            n = 0;
                            stack.pop();
                        } else {
                            n = 0;
                        }
                    }
                    if (n != 0) {
                        res.add(n);
                    }
                }
            }
        }

        LinkedList<Integer> temp = new LinkedList<>();

        while (!stack.empty()) {
            temp.addFirst(stack.pop());
        }

        res.addAll(temp);

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
