package leetcode;

import java.util.*;

public class Demo752 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        for(String s : deadends)
            dead.add(s);
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        int step = 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();

                //判断终点
                if(dead.contains(current))
                    continue;
                if(current.equals(target))
                    return step;

                //加入邻接点
                for (int j = 0; j < 4; j++) {
                    String up = turnUp(current, j);
                    String down = turnDown(current, j);
                    if(!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if(!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String turnDown(String current, int j) {
        StringBuilder sb = new StringBuilder(current);
        char sbj = sb.charAt(j);
        sb.setCharAt(j, sbj=='9'?'0':(char)(sbj+1));
        return sb.toString();
    }

    private String turnUp(String current, int j) {
        StringBuilder sb = new StringBuilder(current);
        char sbj = sb.charAt(j);
        sb.setCharAt(j, sbj=='0'?'9':(char)(sbj-1));
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(new Demo752().openLock(deadends, target));
    }

}
