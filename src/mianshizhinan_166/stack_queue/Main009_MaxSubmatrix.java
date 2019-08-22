package mianshizhinan_166.stack_queue;

/**
 * @author guoxin
 * @version 2019/8/22
 *
 * 给定一个整形矩阵，其中值只有0和1两种，求全是1的所有矩阵中最大的子矩阵面积。
 *
 * 例：
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 *
 * 子矩阵最大面积是6
 *
 * 如果子矩阵大小为N*M，那么可以做到时间复杂度O(N*M)
 *
 * 1.矩阵的行数为N,按行做切割，统计如果以当前行做底，每个位置往上的1的数量
 * 以第1行做底，height={1,0,1,1}
 * 以第2行做底，height={2,1,2,2}
 * 以第3行做底，height={3,2,3,0}
 * 对于每一次切割，都利用更新后的height数组来求出以每一行为底的情况下，最大的矩阵是什么。
 *
 * 1   1
 * 1 1 1
 * 1 1 1
 *
 * 2.考察每一根面积柱能够扩多大。
 * 当旁边没有柱子或者旁边的柱子比当前柱子低时，就无法再扩展。
 */
public class Main009_MaxSubmatrix {

    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < height.length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    public int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;

    }

}
