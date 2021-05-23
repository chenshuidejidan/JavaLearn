package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2021/4/14 - 04 - 14 - 21:24
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo412_130 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0)    res.add("FizzBuzz");
            else if (i % 3 == 0)    res.add("Fizz");
            else if (i % 5 == 0)    res.add("Buzz");
            else res.add(""+i);
        }
        return res;
    }
}
