package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Demo51 {
    private List<List<String>> result = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        backtrack(n, 0, new int[n]);    //int[n]存放解
        return result;
    }
    private void backtrack(int n, int row, int[] position){
        if(row==n){
            //记录结果
            List<String> list = new LinkedList<>();
            for(int x:position){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++)
                    sb.append(i!=x?".":"Q");
                list.add(sb.toString());
            }
            result.add(list);
            return ;  //递归出口
        }
        for (int col = 0; col < n; col++) {   //对一个位置，验证
            //尝试选择
            position[row]=col;
            //验证
            if(!isValid(row,position))
                continue;
            //进入下一行决策
            backtrack(n, row+1, position);
            //撤销选择
        }
    }
    private boolean isValid(int row, int[] position){
        if(row==0) return true;
        for (int row_i = 0; row_i < row; row_i++) {
            if(position[row_i]==position[row] || position[row_i]==(position[row]+row-row_i)||position[row_i]==(position[row]-(row-row_i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Demo51().solveNQueens(4);
        System.out.println(lists);
    }

}
