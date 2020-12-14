package algorithm.leetcode;

import java.util.*;

public class Demo49_28 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> patterns = new HashMap<>();
        if(strs==null||strs.length==0)
            return result;
        for(int i = 0; i<strs.length; i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String s = String.valueOf(chs);
            if(patterns.containsKey(s)){
                int index = patterns.get(s);
                result.get(index).add(s);
            } else {
                patterns.put(s, result.size());
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.add(list);

            }
        }
        return result;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> patterns = new ArrayList<>();
        if(strs==null||strs.length==0)
            return result;
        for(int i = 0; i<strs.length; i++){
            boolean flag = false;
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String s = String.valueOf(chs);
            for(int j = 0; j<patterns.size(); j++){
                if(patterns.get(j).equals(s)){
                    result.get(j).add(strs[i]);
                    flag = true;
                    break;
                }
            }
            if(flag==false){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.add(list);
                patterns.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = new Demo49_28().groupAnagrams(strs);
        System.out.println(lists);
    }
}
