package 用两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

    Stack<Integer> head = new Stack<>();

    Stack<Integer> tail = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        while (!head.isEmpty()) {
            tail.push(head.pop());
        }

        tail.push(value);
    }

    public int deleteHead() {
        while (!tail.isEmpty()) {
            head.push(tail.pop());
        }
        if (head.isEmpty()) {
            return -1;
        }
        return head.pop();
    }
}
