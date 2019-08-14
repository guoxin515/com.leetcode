package mianshizhinan_166.stack_queue;

import java.util.Stack;

/**
 * @author guoxin
 * @version 2019/8/14
 */
public class Main05_SortByOneStack {

    private final Stack<Integer> source;

    public Main05_SortByOneStack() {
        this.source = new Stack<>();
    }

    public void sort(Stack<Integer> source) {
        if (source == null || source.empty()) {
            return;
        }
        Stack<Integer> help = new Stack<>();

        while (!source.empty()) {
            int cur = source.pop();

            while (!help.empty() && cur >= help.peek()) {
                source.push(help.pop());
            }
            source.push(cur);
        }
    }
}
