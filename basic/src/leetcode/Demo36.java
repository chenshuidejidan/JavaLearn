package leetcode;

import java.util.*;

public class Demo36 {
    //一次扫描
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> blocks = new ArrayList<>();



        for(int i = 0; i<board.length; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            blocks.add(new HashSet<>());
        }
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                char ch = board[i][j];
                if(ch!='.'){
                    int block_number = i/3*3 + j/3;
                    Set row = rows.get(i);
                    Set col = cols.get(j);
                    Set block = blocks.get(block_number);
                    if(row.contains(ch)||col.contains(ch)||block.contains(ch))
                        return false;
                    row.add(ch);

                    col.add(ch);

                    block.add(ch);

                }
            }
        }
        return true;
    }



    //三次扫描
    public boolean isValidSudoku2(char[][] board) {
        //判断行
        for(int i = 0; i<board.length; i++){
            Set<Character> set = new HashSet<>();
            int count = 0;
            for(int j = 0; j<board.length; j++){
                if(board[i][j]!='.'){
                    set.add(board[i][j]);
                    count++;
                }
            }
            if(count!=set.size())   return false;
        }
        //判断列
        for(int i = 0; i<board.length; i++){
            Set<Character> set = new HashSet<>();
            int count = 0;
            for(int j = 0; j<board.length; j++){
                if(board[j][i]!='.'){
                    set.add(board[j][i]);
                    count++;
                }
            }
            if(count!=set.size())   return false;
        }
        //判断块
        for(int block=0; block<board.length/3; block++){
            Set<Character> set = new HashSet<>();
            int count = 0;
            for(int i = block/3*3; i<block/3*3+3; i++){
                for(int j = block%3*3; j<block%3*3+3; j++){
                    if(board[i][j]!='.'){
                        set.add(board[i][j]);
                        count++;
                    }
                }
            }
            if(count!=set.size())   return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] board2 = {
                {'.','.','.','.','.','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'9','3','.','.','2','.','4','.','.'},
                {'.','.','7','8','.','.','3','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','4','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','.'},
                {'.','.','.','.','.','5','2','.','.'}
        };

        System.out.println(new Demo36().isValidSudoku(board));
    }
}
