package algorithm.offer;

import org.junit.Test;

public class Demo13 {
    public int movingCount(int m, int n, int k) {
        int count = 0;
        boolean[][] checked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                checked[i][j]=check(i,j,k);
            }
        }
        for(int step = 0; step<m+n; step++){
            for(int i = 0; i< m; i++){
                int j = step-i;
                if(j<0||j>=n)   continue;
                if(i==0&&j==0|| checked[i][j]&&(i-1>=0&& checked[i-1][j]||j-1>=0&& checked[i][j-1])){
                    count++;
                }
                else
                    checked[i][j]=false;
            }
        }
        return count;
    }

    private boolean check(int m, int n, int k){
        int sum = 0;
        while(m>0||n>0){
            sum+=m%10;
            sum+=n%10;
            m/=10; n/=10;
        }
        return sum<=k;
    }

    @Test
    public void test() {
        System.out.println(movingCount(16, 8, 4));
    }
}
