package leetcode;

import com.mysql.jdbc.CacheAdapter;

public class Demo79_42 {
    private char[][] board;
    private char[] words;
    private boolean[][] isVisited;
    private int m;  //board行
    private int n;  //board列
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0)    return false;
        this.board = board;
        this.words = word.toCharArray();
        this.isVisited = new boolean[board.length][board[0].length];
        m = board.length;
        n = board[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(backtrack(i, j, 0, isVisited))  return true;
            }
        }
        return false;
    }

    private boolean backtrack(int x, int y, int count, boolean[][] isVisited) {
        if(board[x][y] != words[count] || isVisited[x][y]) return false;
        isVisited[x][y] = true;
        if(count==words.length-1)   return true;
        if(x-1>=0&&backtrack(x-1,y,count+1,isVisited)|| x+1<m&&backtrack(x+1,y,count+1,isVisited)||
            y-1>=0&&backtrack(x,y-1,count+1,isVisited)|| y+1<n&&backtrack(x,y+1,count+1,isVisited))
            return true;
        isVisited[x][y] = false;    //回溯
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B'},{'C','D'}};
        String word = "ACDB";
        System.out.println(new Demo79_42().exist(board, word));
    }
}
