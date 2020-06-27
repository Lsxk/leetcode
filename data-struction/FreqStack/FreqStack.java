package FreqStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 * <p>
 * FreqStack 有两个函数：
 * <p>
 * push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 */
public class FreqStack {

    // x --> freq
    Map<Integer, Integer> freq = new HashMap<>();

    //freq --> stack
    Map<Integer, Stack<Integer>> stackMap = new HashMap<>();

    int maxFreq = 0;

    public FreqStack() {

    }

    public void push(int x) {
        int freqX = this.freq.getOrDefault(x, 0) + 1;
        freq.put(x, freqX);

        if (freqX > maxFreq) {
            maxFreq = freqX;
        }

        stackMap.computeIfAbsent(freqX, integer -> new Stack<>()).push(x);
    }

    public int pop() {
        int x = stackMap.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (stackMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
    }
}
