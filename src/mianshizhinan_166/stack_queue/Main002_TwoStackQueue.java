package mianshizhinan_166.stack_queue;

import java.util.Stack;

/**
 * @author guoxin
 * @version 2019/8/10
 *
 * 用2个栈实现一个队列,只需要实现add,poll,peek
 *
 * 队列常规操作
 * 添加  add(会抛异常)  offer
 * 弹出删除 remove(会抛异常) poll
 * 获得不删除 element(会抛异常)   peek
 *
 *
 * 解：队列先进先出，栈先进后出。元素先添加到in栈，当元素要弹出时，先把in栈的元素依次全部添加到out栈。然后从out栈弹出。
 * 但是当第一次全部压入out栈后，再次弹出时，只要out栈不为空，元素就应该直接从out栈弹出。直到out栈为空，再从in栈中把所有元素转移到out栈。
 */
public class Main002_TwoStackQueue {

    public static void main(String[] args){
    }

    private final Stack<Integer> stackIn;
    private final Stack<Integer> stackOut;

    public Main002_TwoStackQueue(Stack<Integer> stackIn, Stack<Integer> stackOut) {
        this.stackIn = stackIn;
        this.stackOut = stackOut;
    }

    public boolean add(Integer in) {
        stackIn.push(in);
        return true;
    }

    public Integer peek() {
        if (stackOut.empty() && stackIn.empty()) {
            return null;
        }
        if (!stackOut.empty()) {
            return stackOut.peek();
        }
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.peek();
    }

    public Integer poll() {
        if (stackOut.empty() && stackIn.empty()) {
            return null;
        }
        if (!stackOut.empty()) {
            return stackOut.pop();
        }
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }
}
