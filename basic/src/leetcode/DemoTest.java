package leetcode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        int n = 3;
        int nthBit = 1 << n;
        for (int i = 0; i < (int) Math.pow(2, n); ++i) {
            // generate bitmask, from 0..00 to 1..11
            int a = i|nthBit;
            String bitmask1 = Integer.toBinaryString(a);
            String bitmask = bitmask1.substring(1);
            System.out.println(bitmask);
        }
    }
}
