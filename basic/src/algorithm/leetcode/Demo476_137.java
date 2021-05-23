package algorithm.leetcode;

/**
 * @Auther: c
 * @Date: 2021/4/19 - 04 - 19 - 17:03
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo476_137 {
    public int findComplement(int num) {
        int temp = 1;
        while (temp < num) temp = (temp << 1) + 1;
        return num & temp ^ temp;
    }

    public static void main(String[] args) {
        System.out.println(new Demo476_137().findComplement(2147483647));
    }
}
