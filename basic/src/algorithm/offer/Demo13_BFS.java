package algorithm.offer;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Demo13_BFS {
    public int movingCount(int m, int n, int k) {
        //bfs
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        Deque<int[]> queue = new LinkedList<>();
        int[] root = {0, 0};
        queue.offer(root);
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (visited[position[0]][position[1]]) continue;
            visited[position[0]][position[1]] = true;
            count++;
            for (int i = 0; i <= 1; i++) {
                int j = 1 - i;
                if(position[0]+i<m && position[1]+j<n){
                    int[] adj = {position[0] + i, position[1] + j};
                    if (check(adj[0], adj[1], k) && !visited[adj[0]][adj[1]])
                        queue.offer(adj);
                }
            }

        }
        return count;
    }

    private boolean check(int m, int n, int k) {
        int sum = 0;
        while (m > 0 || n > 0) {
            sum += m % 10;
            sum += n % 10;
            m /= 10;
            n /= 10;
        }
        return sum <= k;
    }

    @Test
    public void test() {
        System.out.println(movingCount(8, 2, 6));
    }
}
