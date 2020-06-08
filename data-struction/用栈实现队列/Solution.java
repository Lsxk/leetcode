package 用栈实现队列;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空
 *
 */
public class Solution {
    /** Initialize your data structure here. */
    private Stack<Integer> head = new Stack<>();

    private Stack<Integer> tail = new Stack<>();
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        tail.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (head.isEmpty()) {

            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }
        return head.pop();
    }

    /** Get the front element. */
    public int peek() {
        return head.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }
}
