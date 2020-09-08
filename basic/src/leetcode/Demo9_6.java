package leetcode;

public class Demo9_6 {
    //转String
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        String s = Integer.toString(x);
        char[] chs = s.toCharArray();
        int left = 0;
        int right = chs.length-1;
        while(left<=right&&chs[left++]==chs[right--]){
            if(left>=right){
                return true;
            }
        }
        return false;
    }

    //不转String
    public boolean isPalindrome2(int x) {
        if(x<0||x%10==0&&x!=0) {
            return false;
        }
        int y = 0;
        while(x>=0){
            y=y*10+x%10;
            x/=10;
            if(y>=x){   //当y大于等于x说明已经到了一半了！！！！
                return y==x||y/10==x;   //判断两种情况
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(new Demo9_5().isPalindrome(0));
        System.out.println(new Demo9_6().isPalindrome2(0));
    }
}
