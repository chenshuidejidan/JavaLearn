package cn.hit03.string;

public class StringDemoMethod {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "hellooasoaosa";
        System.out.println(s1.length());     //获取长度//2
        System.out.println(s1.concat(s2));   //拼接//java
        System.out.println(s1.charAt(1));    //获取指定索引的字符//'a'
        System.out.println(s1.indexOf('j')); //获取字符第一次出现的索引//0
        System.out.println(s1.substring(1,3)); // [1,3)

        char[] c = s1.toCharArray();          //字符串拆分为字符数组返回
        byte[] b = s1.getBytes();             //获得底层字节数组
        String s3 = s2.replace("o","*"); //内容替换//hell****as*a*sa

        String[] s4 = s2.split("o");    //返回字符数组,按正则匹配切分

        System.out.println(c);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
        System.out.println(s3);

        for (int i = 0; i < s4.length; i++) {
            System.out.println(s4[i]);
        }


    }
}
