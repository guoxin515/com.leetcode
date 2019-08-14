package mianshizhinan_166.stack_queue;

import java.util.Stack;

/**
 * @author guoxin
 * @version 2019/8/10
 *
 * 实现栈中元素逆序，要求只能使用递归函数实现，不能用其他数据结构。
 */
public class Main03_ReverseStack {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

   private static int getAndRemoteLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoteLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoteLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

}
