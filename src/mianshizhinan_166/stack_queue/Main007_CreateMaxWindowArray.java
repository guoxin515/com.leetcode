package mianshizhinan_166.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author guoxin
 * @version 2019/8/15
 *
 * 生成窗口最大值数组
 * 输入一个数组a，长度为n，窗口大小为w。那么一个有n-w+1个滑动窗口，输出每一个滑动窗口中的最大值。
 * [4,3,5,4,3,3,6,7]
 * 输出[5,5,5,4,6,7]
 */
public class Main007_CreateMaxWindowArray {

    // 方法1
    // 先获取n-w+1 个子数组，然后求每个子数组的最大值
    public static int[] getMaxWindowArray1(int[] arr, int w) {
        List<int[]> list = new ArrayList<>();

        // O(n*w)
        for (int i = 0; i <= arr.length - w; i++) {
            int[] wd = new int[w];
            for (int j = i; j < i+w; j++) {
                wd[j-i] = arr[j];
            }
            list.add(wd);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = getMaxNumOfList(list.get(i));
        }
        return result;
    }

    // 方法2
    // 使用双端队列。队列中放数组当前循环到的下标。依次比较队列尾部的数组下标对应的值 与 数组当前下标对应的值。
    // LOOP:当前值大于尾部值，则弹出尾部值,直到当前值小于队列中的值或队列为空。再把当前值插入队尾。
    // 设队列队尾下标为t，如果 t-w=队首下标，说明队首已经过期，需要弹出
    public static int[] getMaxWindowArray2(int[] arr, int w) {
        LinkedList<Integer> deque = new LinkedList<>();

        int[] result = new int[arr.length - w + 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - w) {
                deque.pollFirst();
            }
            // 第一个最大数放入，需要i循环到第一个窗口尾部
            if (i >= w - 1) {
                result[index++] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    /**
     * O(n)
     */
    private static int getMaxNumOfList(int[] list) {
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(getMaxWindowArray2(arr, 3)));
    }
}
