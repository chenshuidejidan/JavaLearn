package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2021/4/14 - 04 - 14 - 14:56
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo406_128 {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(new Demo406_128().reconstructQueue(people)));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2)->{
                if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                }
                return p1[1] - p2[1];
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
