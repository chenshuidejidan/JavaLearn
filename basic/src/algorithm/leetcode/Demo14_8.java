package algorithm.leetcode;

public class Demo14_8 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)  return "";
        String min_str = strs[0];
        int min_length = min_str.length();
        for(int i =0; i<strs.length; i++){
            if(strs[i].length()<min_length)
                min_str = strs[i];
            min_length=min_str.length();
        }

        for(String str:strs){
            int i = 0;
            while(i<min_length&&str.charAt(i)==min_str.charAt(i)){
                i++;
            }
            if(i==0) return "";
            min_length = Math.min(min_length, i);
        }
        return min_length==0?"":min_str.substring(0,min_length);
    }

    public static void main(String[] args) {
        System.out.println(new Demo14_8().longestCommonPrefix(new String[]{"a"}));
    }
}
