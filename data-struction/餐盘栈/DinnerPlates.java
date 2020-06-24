package 餐盘栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 功能描述：
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 * <p>
 * 实现一个叫「餐盘」的类 DinnerPlates：
 * <p>
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class DinnerPlates {
    LinkedList<Stack<Integer>> list = new LinkedList<>();

    int capacity;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        for (Stack<Integer> s : list) {
            if (s.size() < capacity) {
                s.push(val);
                return;
            }
        }
        Stack<Integer> s = new Stack<>();
        s.push(val);
        list.addLast(s);
    }

    public int pop() {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!list.get(i).isEmpty()) {
                return list.get(i).pop();
            }
        }
        return -1;
    }

    public int popAtStack(int index) {
        if (list.size() > index) {
            if (list.get(index) != null && !list.get(index).isEmpty()) {
                return list.get(index).pop();
            }
            return -1;
        }
        return -1;
    }
}
