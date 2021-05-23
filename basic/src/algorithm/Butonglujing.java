package algorithm;

/**
 * @Auther: c
 * @Date: 2021/3/28 - 03 - 28 - 19:52
 * @Description: algorithm
 * @Version: 1.0
 */
public class Butonglujing {

    public int uniquePaths(int[][] grids) {
        int n = grids.length, m = grids[0].length;
        int[] f = new int[m];

        f[0] = grids[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grids[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && grids[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }
}


