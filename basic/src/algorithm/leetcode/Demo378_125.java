package algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @Auther: c
 * @Date: 2021/4/13 - 04 - 13 - 16:42
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo378_125 {
    public static void main(String[] args) {

    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[0]-o2[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
}
