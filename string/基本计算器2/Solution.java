package 基本计算器2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * <p>
 * <p>
 * 思路：
 * <p>
 * 将表达式（中缀）转化为后缀
 * 将后缀计算出结果
 * 具体规则为：
 * 1.中缀转后缀：
 * - 数字直接输出到后缀表达式
 * - 栈为空时，遇到运算符，直接入栈
 * - 遇到运算符，弹出所有优先级大于或等于该运算符的栈顶元素，并将该运算符入栈
 * - 将栈中元素依次出栈
 * <p>
 * 例如：表达式：3+2 * 2
 * 遇到3，直接输出到后缀表达式中，栈中元素为空，结果为： 栈： 空； 后缀表达式：3
 * 遇到符号“+”，入栈，结果为： 栈：+ ； 后缀表达式：3
 * 遇到2，直接输出，结果为： 栈：+； 后缀表达式： 3 2
 * 遇到乘号*，入栈，结果为： 栈： * + ；后缀表达式：3 2
 * 遇到2，直接输出，结果为： 栈： * + ；后缀表达式：3 2 2
 * 最后，将元素出栈：结果为：后缀表达式：3 2 2 * +
 * <p>
 * 2.计算后缀：
 * - 遇到数字，入栈
 * - 遇到运算符，弹出栈顶两个元素，做运算，并将结果入栈
 * - 重复上述步骤，直到表达式最右端
 * <p>
 * 例如上述得到的后缀表达式为 3 2 2 * +
 * 3 2 2 都是数字，入栈，结果为：栈：2 2 3
 * 遇到* 号， 2 2 出栈，并计算，2*2 = 4, 4入栈，结果为：栈：4 3 ，表达式还剩一个加号
 * 遇到+ 号，栈顶两个元素出栈并运算，4 3 做加法，4+3 =7
 * 后缀表达式空了，计算完毕，输出结果：7
 * <p>
 * 作者：nopdes1resun
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii/solution/zhan-de-jing-dian-ying-yong-ji-suan-qi-by-nopdes1r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    Map<Character, Integer> pr = new HashMap<Character, Integer>() {{
        put('*', 2);
        put('/', 2);
        put('+', 1);
        put('-', 1);
    }};

    public int calculate(String s) {
        List<String> houzui = convertor(s);

        //计算后缀
        Stack<String> stack = new Stack<>();

        for (String c : houzui) {
            if (c.length() == 1 && !Character.isDigit(c.charAt(0))) {
                //是符号
                String num1 = stack.pop();
                String num2 = stack.pop();

                switch (c.charAt(0)) {
                    case '/':
                        stack.push((Integer.parseInt(num2) / Integer.parseInt(num1)) + "");
                        break;
                    case '*':
                        stack.push((Integer.parseInt(num2) * Integer.parseInt(num1)) + "");
                        break;
                    case '+':
                        stack.push((Integer.parseInt(num2) + Integer.parseInt(num1)) + "");
                        break;
                    case '-':
                        stack.push((Integer.parseInt(num2) - Integer.parseInt(num1)) + "");
                        break;

                }

            } else {
                stack.push(c);
            }
        }

        return Integer.parseInt(stack.pop());

    }

    private List<String> convertor(String s) {

        List<String> sb = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                temp.append(c);
            } else {
                //先将上个数字放入后缀
                if (temp.length() > 0) {
                    sb.add(temp.toString());

                    temp = new StringBuilder();
                }

                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    //弹出优先级高的
                    while (!stack.isEmpty() && pr.get(stack.peek()) >= pr.get(c)) {
                        sb.add(stack.pop() + "");
                    }

                    stack.push(c);
                }
            }
        }
        //最后可能还有一个数字
        if (temp.length() > 0) {
            sb.add(temp.toString());
        }

        //最后将栈里的全部加入后缀
        while (!stack.isEmpty()) {
            sb.add(stack.pop() + "");
        }

        return sb;

    }

}
