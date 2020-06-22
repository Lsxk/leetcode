package 用队列实现栈;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyStack {
    /** Initialize your data structure here. */
    Queue<Integer> pushQueue = new LinkedBlockingQueue<>();

    Queue<Integer> popQueue = new LinkedBlockingQueue<>();
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        pushQueue.offer(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        while (!pushQueue.isEmpty()) {
            popQueue.offer(pushQueue.poll());
        }

        return popQueue.poll();

    }

    /** Get the top element. */
    public int top() {
        while (!pushQueue.isEmpty()) {
            popQueue.offer(pushQueue.poll());
        }

        return popQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return popQueue.isEmpty() && pushQueue.isEmpty();
    }
}
