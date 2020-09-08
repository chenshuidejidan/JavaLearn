package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo54_31 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while(start<(rows+1)/2 && start<(cols+1)/2){
            for(int col = start; col<cols-start; col++) result.add(matrix[start][col]);
            for(int row = start+1; row<rows-start; row++) result.add(matrix[row][cols-start-1]);
            for(int col = cols-start-2; col>start&&rows-start-1>start; col--) result.add(matrix[rows-start-1][col]);
            for(int row = rows-start-1; row>start&&start<cols-start-1; row--) result.add(matrix[row][start]);
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1},{2},{3}};
        List<Integer> integers = new Demo54_31().spiralOrder(matrix);
        System.out.println(integers);
    }
}
