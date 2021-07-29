package test;

/**
 * @Auther: c
 * @Date: 2021/7/17 - 07 - 17 - 19:20
 * @Description: test
 * @Version: 1.0
 */
public class Stringlen {
    public static void main(String[] args) throws NoSuchMethodException {
        // emoji 代表表情
        String emoji= "👴";
        System.out.println(emoji.length());

        String s1 = "a";
        String s2 = "b";
        String s4 = s1 + s2;
        String s3 = "ab";
        System.out.println(s3==s4);
    }
}
