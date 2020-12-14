package algorithm.offer;

import java.util.*;

/**
 * @Auther: c
 * @Date: 2020/11/23 - 11 - 23 - 14:35
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo38 {
    public Set<String> res = new HashSet<>();
    public String[] permutation(String s) {
        char[] chs = s.toCharArray();
        for(int i = 0; i<s.length(); i++){
            boolean[] isVisited = new boolean[chs.length];
//            isVisited[i]=true;
            dfs(chs, i, new StringBuilder(), isVisited);
        }
        List<String> list = new ArrayList<>();
        list.addAll(res);
        return list.toArray(new String[list.size()]);
    }

    private void dfs(char[] chs, int index, StringBuilder sb, boolean[] isVisited){
        isVisited[index]=true;
        sb.append(chs[index]);
        if(sb.length()==chs.length){
            res.add(sb.toString());
            return;
        }
        for(int i = 0; i<chs.length; i++){
            if(!isVisited[i]){
                dfs(chs, i, sb, isVisited);
                isVisited[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = new Demo38().permutation("abc");
        System.out.println(Arrays.toString(strings));
    }
}
