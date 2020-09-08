package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo22_16 {
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n<=0) return result;
        StringBuilder sb = new StringBuilder("(");
        backtrack(sb, n, 1, 1);
        return result;
    }

    private void backtrack(StringBuilder sb, int n, int countl, int count){
        //判断,出口
        if(countl>n||count<0||sb.length()==2*n){
            if(count==0)
                result.add(sb.toString());
            return;
        }

        //选择(
        sb.append('(');
        backtrack(sb, n, countl+1, count+1);
        sb.deleteCharAt(sb.length()-1);

        //选择)
        sb.append(')');
        backtrack(sb, n, countl, count-1);
        sb.deleteCharAt(sb.length()-1);
    }

//    private List<String> result = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        if(n<=0) return result;
//        char[] chars = new char[2*n];
//        backtrack(chars, n, 0, 0, 0);
//        return result;
//    }
//
//    private void backtrack(char[] chars, int n, int countl, int count, int position){
//        //判断,出口
//        if(countl>n||count<0||position==2*n){
//            if(count==0)
//                result.add(String.valueOf(chars));
//            return;
//        }
//        //选择
//        chars[position]='(';
//        backtrack(chars, n, countl+1, count+1, position+1);
//
//        //撤销
//        chars[position]=')';
//        backtrack(chars, n, countl, count-1, position+1);
//    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Demo22_16().generateParenthesis(n));
    }
}
