package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo56_33 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (o1, o2)-> o1[0]-o2[0]);
        int[][] result = new int[intervals.length][2];
        int count = 0;
        int low = intervals[0][0];
        int high = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0]>high){
                result[count][0] = low;
                result[count][1] = high;
                count++;
                low = intervals[i][0];
                high = intervals[i][1];
            }else{
                high = Math.max(high, intervals[i][1]);
            }
        }
        result[count][0] = low;
        result[count][1] = high;
        return Arrays.copyOf(result, count+1);
    }

    public int[][] merge2(int[][] intervals) {
        if(intervals==null||intervals.length==0)    return new int[0][0];
        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();
        int count = 0;
        for(int i=0; i<intervals.length; i++){
            if(low.size()==0){
                low.add(intervals[i][0]);
                high.add(intervals[i][1]);
                count++;
            }else{
                int lowest = intervals[i][0];
                int highest = intervals[i][1];
                for(int j=0; j<low.size(); j++){
                    if(low.get(j)==Integer.MAX_VALUE||low.get(j)>=highest||high.get(j)<=lowest) continue;
                    else{
                        lowest = Math.min(lowest, low.get(j));
                        highest = Math.max(highest, high.get(j));
                        low.set(j,Integer.MAX_VALUE);
                        high.set(j, Integer.MAX_VALUE);
                        count--;
                    }
                }
                low.add(lowest);
                high.add(highest);
                count++;
            }
        }
        int[][] res = new int[count][2];
        int j = 0;
        for(int i=0; i<low.size(); i++){
            if(low.get(i)!=Integer.MAX_VALUE){
                res[j][0] = low.get(i);
                res[j][1] = high.get(i);
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new Demo56_33().merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }
}
