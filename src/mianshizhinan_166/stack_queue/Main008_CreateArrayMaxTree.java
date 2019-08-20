package mianshizhinan_166.stack_queue;

import java.util.HashMap;
import java.util.Stack;
import mianshizhinan_166.stack_queue.util.Node;

/**
 * @author guoxin
 * @version 2019/8/20
 *
 * 一个数组的MaxTree定义如下：
 * 1、数组没有重复元素
 * 2、MaxTree是一颗二叉树，数组的每一个值对应一个二叉树节点。
 * 3、包括MaxTree树在内的每一颗子树，值最大的节点都是树的头。
 *
 *
 * 输入数组arr，长度为N，要求时间复杂度O(N),控件复杂度O(N)
 *
 * 解法：
 * 每一个数的父节点是它左边第一个比它大的数和右边第一个比它大的数中比较小的一个。
 * 如果一个数左右都没有比它大的数，那么它就是整个数组的最大值，即MaxTree的头结点。
 */
public class Main008_CreateArrayMaxTree {


    public Node getMaxTree(int[] arr) {

        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node,Node> lBigMap = new HashMap<>();
        HashMap<Node,Node> rBigMap = new HashMap<>();

        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            while (!stack.empty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.empty()) {
            popStackSetMap(stack, lBigMap);
        }

        for (int i = nArr.length-1; i >= 0; i--) {
            Node curNode = nArr[i];
            while (!stack.empty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.empty()) {
            popStackSetMap(stack, lBigMap);
        }

        Node head = null;

        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);

            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }

        return head;

    }

    /**
     * 这是一个栈底元素一定比栈顶大的栈，弹出第一个比栈顶大的数
     * @param stack
     * @param map
     */
    public void popStackSetMap(Stack<Node> stack, HashMap<Node,Node> map) {
        Node popNode = stack.pop();
        if (stack.empty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }


}


