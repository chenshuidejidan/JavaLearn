package algorithm.offer;

public class Demo05 {
    public String replaceSpace(String s) {
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==' ')
                count++;
        }
        char[] chars = s.toCharArray();
        char[] chs = new char[s.length()+2*count];
        int j = chs.length-1;
        for(int i = chars.length-1; i>=0; i--){
            if(chars[i]!=' ')
                chs[j--]=chars[i];
            else{
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = new Demo05().replaceSpace(s);
        System.out.println(s1);
    }
}
