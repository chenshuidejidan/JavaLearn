package algorithm.offer;

/**
 * @Auther: c
 * @Date: 2020/11/22 - 11 - 22 - 13:06
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo20 {
    public boolean isNumber(String s) {
        char[] chs = s.toCharArray();
        int countNum=0;
        int countDot=0;
        int countE=0;
        int countSymbol=0;
        for(int i =0; i<chs.length; i++){
            char c= chs[i];
            if(c=='+'||c=='-'){
                countSymbol++;
                if(countSymbol>2||(i!=0&&(c=='+'||c=='-'&&!(chs[i-1]=='e'||chs[i-1]=='E'))))
                    return false;
            }else if(c=='.'){
                countDot++;
                if(countDot>1||!(i>=1&&i<chs.length-1&&chs[i-1]>='0'&&chs[i-1]<='9'&&(chs[i+1]=='-'||chs[i+1]>='0'&&chs[i+1]<='9')))
                    return false;
            }else if(c=='e'||c=='E'){
                countE++;
                if(countE>1||!(i>=1&&i<chs.length-1&&chs[i-1]>='0'&&chs[i-1]<='9'&&(chs[i+1]=='-'||chs[i+1]>='0'&&chs[i+1]<='9')))
                    return false;
            }else if(c>='0'&&c<='9'){
                countNum++;
            }else return false;
        }
        if(countNum==0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Demo20().isNumber("1"));
    }
}
