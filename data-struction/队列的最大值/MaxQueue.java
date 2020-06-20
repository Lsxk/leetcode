package 队列的最大值;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class MaxQueue {

    private Queue<Integer> queue = new LinkedBlockingQueue<>();

    private Deque<Integer> deque = new LinkedBlockingDeque<>(); // 单调递减的双端队列

    public MaxQueue() {

    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peek();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        int ans = queue.poll();
        if (ans == deque.peek()) {
            deque.poll();
        }
        return ans;
    }
}
