package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author guoxin
 * @version 2019/8/7
 *
 *
 * 题目描述
写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

输入描述:
第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。

输出描述:
输出输入字符串中含有该字符的个数。

示例1
输入
复制
ABCDEF
A
输出
1

 */
public class Main002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input1 = sc.nextLine();
            String input2 = sc.nextLine();
            check(input1, input2);
            System.out.println(getNumOfInput2Char(input1.toLowerCase(), input2.toLowerCase()));
        }
    }

    private static void check(String data, String target) {
        Objects.requireNonNull(data);
        if (null == target || target.length() > 1) {
            throw new RuntimeException("第二行字符输入有误");
        }
    }

    private static int getNumOfInput2Char(String data, String target) {
        String[] datas = data.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String ch : datas) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        return 0;
    }

}
