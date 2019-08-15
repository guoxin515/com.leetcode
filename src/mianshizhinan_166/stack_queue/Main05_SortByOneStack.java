package mianshizhinan_166.stack_queue;

import java.util.Stack;

/**
 * @author guoxin
 * @version 2019/8/14
 *
 * 将栈中元素进行栈顶到底 从大到小排序，并且只允许申请一个栈，除此之外只可以申请新的变量。
 *
 * 解：
 * 想象一下有2个杯子，将杯子里的水来回倒。
 * 1、将source栈顶的元素赋值给一个变量，如果help为空，直接将source栈顶元素压入help栈。从第一步从新开始。
 *    然后将source栈中元素弹出依次和help栈顶的元素做比较，如果元素小于help栈顶元素，则将元素压入help栈。
 *    如果大于，则依次将help栈中的元素取出，然后跟source栈弹出的元素做比较，如果小于，则放回source栈；
 *    大于则停止，并把help栈顶压入help栈，继续回到第一步开头。
 */
public class Main05_SortByOneStack {

    public Main05_SortByOneStack() {
    }

    public void sort(Stack<Integer> source) {
        if (null == source || source.empty()) {
            return;
        }
        Stack<Integer> help = new Stack<>();
        while (!source.empty()) {
            int head = source.pop();
            // 自己写的
            /*if (help.empty()) {
                help.push(head);
            } else if (head < help.peek()) {
                help.push(head);
            } else {
                while (!help.empty()) {
                    int top = help.peek();
                    if (head > top) {
                        source.push(help.pop());
                    } else {
                        help.push(head);
                        break;
                    }
                }
            }*/
            // 书上写的
            while (!help.empty() && head > help.peek()) {
                source.push(help.pop());
            }
            help.push(head);
        }
        System.out.println(help);
        while (!help.empty()) {
            source.push(help.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> source = new Stack<>();
        source.push(2);
        source.push(3);
        source.push(5);
        source.push(4);
        source.push(1);
        source.push(8);
        // top->low  8 1 4 5 3 2
        Main05_SortByOneStack sortByOneStack = new Main05_SortByOneStack();
        sortByOneStack.sort(source);
        System.out.println(source);
    }
}
