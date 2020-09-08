package leetcode;

import java.util.*;

public class Demo17_11 {
    //深度优先搜索
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        depthFirstSearch(digits, new StringBuilder(), map, 0, list);
        return list;
    }
    private void depthFirstSearch(String digits, StringBuilder sb, String[] map, int index, List<String> list){
        if(index==digits.length()){
            list.add(sb.toString());
            return;     //递归出口
        }
        String s = map[digits.charAt(index)-'0'];
        for(char ch : s.toCharArray()) {
            depthFirstSearch(digits, sb.append(ch), map, index + 1, list);
            sb.deleteCharAt(sb.length()-1);     //StringBuilder是字符串变量，添加ch是在原字符串添加的，需要去除
        }
    }



    //广度优先搜索BFS
    public List<String> letterCombinations1(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int curor = 0;    //指示当前位置
        list.add("");
        while (curor < digits.length()) {
            while (list.peek().length() <= curor) {
                String s = list.remove();
                for (char c : map[digits.charAt(curor)-'0'].toCharArray()) {
                    list.add(s + c);
                }
            }
            curor++;
        }
        return list;
    }



    //随机数穷举，性能不好
    public List<String> letterCombinations3(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = digits.toCharArray();
        int totalCount = 1;
        for (char ch : chars) {
            if (ch > '1' && ch < '7' || ch == '8')
                totalCount *= 3;
            if (ch == '7' || ch == '9')
                totalCount *= 4;
        }
        if (totalCount == 1) return list;
        int count = 0;
        while (count < totalCount) {
            char[] ch_now = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < '7')
                    ch_now[i] = (char) (new Random().nextInt(3) + (chars[i] - '2') * 3 + 'a');
                if (chars[i] == '7')
                    ch_now[i] = (char) (new Random().nextInt(4) + 'p');
                if (chars[i] == '8')
                    ch_now[i] = (char) (new Random().nextInt(3) + 't');
                if (chars[i] == '9')
                    ch_now[i] = (char) (new Random().nextInt(4) + 'w');
            }
            String ch = new String(ch_now);
            if (!map.containsKey(ch)) {
                map.put(ch, count++);
            }
        }
        list = new ArrayList<>(map.keySet());
        return list;
    }

    public static void main(String[] args) {
        String input = "23";
        System.out.println(new Demo17_11().letterCombinations(input));
    }
}
