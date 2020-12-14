package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo39_24 {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)  return result;
        backtrack(candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> list, int curor){
        if(target==0){   //正确答案出口
            result.add(new ArrayList<>(list));      //一定要new，否则list回溯改变后这里也跟着改变了
            return;
        }else if(target<0){ //错误答案出口
            return;
        }else{
            for(int i = curor; i<candidates.length && candidates[i]<=target;i++){
                list.add(candidates[i]);
                backtrack(candidates, target-candidates[i], list, i);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new Demo39_24().combinationSum(candidates, target));
    }
}
