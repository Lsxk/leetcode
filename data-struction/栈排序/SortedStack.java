package 栈排序;

import java.util.Stack;

/**
 * 功能描述：
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * @version 1.0.0
 * @since 2020-06-20
 */
public class SortedStack {

    Stack<Integer> sortedStack = new Stack<>();

    Stack<Integer> helper = new Stack<>();

    public SortedStack() {

    }

    public void push(int val) {
        while (!sortedStack.isEmpty() && sortedStack.peek() < val) {
            helper.push(sortedStack.pop());
        }
        sortedStack.push(val);
        while (!helper.isEmpty()) {
            sortedStack.push(helper.pop());
        }
    }

    public void pop() {
        if (!sortedStack.isEmpty()) {
            sortedStack.pop();
        }
    }

    public int peek() {
        if (sortedStack.isEmpty()) {
            return -1;
        }
        return sortedStack.peek();
    }

    public boolean isEmpty() {
        return sortedStack.isEmpty();
    }
}
