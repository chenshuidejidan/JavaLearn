package leetcode;

import java.util.HashMap;

public class Demo3_3 {
    public int lengthOfLongestSubstring(String s) {
        //HashMap实现
        if(s==null||s.length()==0) return 0;
        int right = 0;
        int left = 0;
        int maxLength = 0;  //记录结果
        HashMap<Character, Integer> map = new HashMap<>();
        while(right<s.length()){
            map.put(s.charAt(right), right);

            //收紧左侧窗口
            if(map.containsKey(s.charAt(right))){
                //left变为离right处最近的重复字母+1
                //max保证left不会回退：如abba 保证right到达第二个a时left不会回退到第一个a处
                left = Math.max(left,map.get(s.charAt(right))+1);
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
    //     //用链表实现队列，队列是先进先出的
    //     Queue<Character> queue = new LinkedList<>();
    //     int res = 0;
    //     for (char c : s.toCharArray()) {
    //         while (queue.contains(c)) {
    //             //如果有重复的，队头出队
    //             queue.poll();
    //         }
    //         //添加到队尾
    //         queue.add(c);
    //         res = Math.max(res, queue.size());
    //     }
    //     return res;
    // }
}
