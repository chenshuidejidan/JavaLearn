package algorithm.offer;

import java.util.Arrays;

/**
 * @Auther: c
 * @Date: 2020/11/22 - 11 - 22 - 15:57
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0)    return null;
        if(matrix[0]==null||matrix[0].length==0) return null;
        int start = 0; //每次打印的起始位置(x,y)=(start, start)
        int endrow = matrix.length-1; //每次打印的结束行
        int endcol = matrix[0].length-1; //每次打印的结束列
        int[] res = new int[matrix.length*matrix[0].length];
        int index = 0; //标记位置
        while(endcol>=start&&endrow>=start){
            for(int j = start; j<=endcol; j++) res[index++]=matrix[start][j];
            for(int i = start+1; i<=endrow; i++) res[index++]=matrix[i][endcol];
            endcol--;
            for(int j = endcol; j>=start && endrow>start; j--)  res[index++]=matrix[endrow][j];
            endrow--;
            for(int i = endrow; i>start && start<=endcol; i--)  res[index++]=matrix[i][start];
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1},{2},{3}};
        int[] ints = new Demo29().spiralOrder(arr);
        System.out.println(Arrays.toString(ints));

    }
}
