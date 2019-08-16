package mianshizhinan_166.stack_queue;

import java.util.Stack;

/**
 * @author guoxin
 * @version 2019/8/10
 *
 * 实现一个特殊的栈，在实现栈最基本功能的基础上。能够实现返回栈中最小的元素。
 */
public class Main001_getMinStack {

    private final Stack<Integer> normalStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    // normalStack正常放入，minStack只放入当前最小的元素
    public Integer push(Integer num) {
        if (minStack.empty()) {
            minStack.push(num);
        } else if (num <= minStack.peek()) {
            minStack.push(num);
        } else if (num > minStack.peek()) {
            minStack.push(minStack.peek());
        }
        return normalStack.push(num);
    }

    public Integer pop() {
        if (normalStack.isEmpty()) {
            throw new RuntimeException("error");
        }
        minStack.pop();
        return normalStack.pop();
    }

    public Integer getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("error");
        }
        return minStack.peek();
    }

}
