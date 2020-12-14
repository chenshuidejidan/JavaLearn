package algorithm.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/12/7 - 12 - 07 - 19:32
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo60 {
    @Test
    public void test(){
        String s = getPermutation(4, 2);
        System.out.println(s);
    }

    private int[] factor;

    public String getPermutation(int n, int k) {    //1...n的数，排列第k个
        boolean[] visited = new boolean[n+1];
        factor = new int[n];
        calculateFactor(n);
        StringBuilder sb = new StringBuilder();
        dfs(n,k,visited, sb);
        return sb.toString();
    }


    private void dfs(int n, int k, boolean[] visited, StringBuilder sb){
        if(sb.length()==n){
            return ;
        }

        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                if(factor[n-1-sb.length()]<k){
                    k-=factor[n-1-sb.length()];
                    continue;
                }
                visited[i] = true;
                sb.append(i);
                dfs(n,k,visited, sb);
                return;
            }
        }
    }

    private void calculateFactor(int n){
        factor[0]=1;
        for(int i = 1; i<n; i++){
            factor[i] = factor[i-1]*i;
        }
    }





    public String getPermutation2(int n, int k) {
        // 注意：相当于在 n 个数字的全排列中找到下标为 k - 1 的那个数，因此 k 先减 1
        k--;
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        // i 表示剩余的数字个数，初始化为 n - 1
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            stringBuilder.append(nums.remove(index));
            k -= index * factorial[i];
        }
        return stringBuilder.toString();
    }
}
