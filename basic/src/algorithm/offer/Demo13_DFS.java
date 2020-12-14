package algorithm.offer;

import org.junit.Test;

public class Demo13_DFS {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(!check(i,j,k)||i>=m||j>=n||visited[i][j])   return 0;
        visited[i][j]=true;
        return dfs(i+1,j,m,n,k,visited)+dfs(i,j+1,m,n,k,visited)+1;
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
