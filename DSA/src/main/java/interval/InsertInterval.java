package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{2,6},{2,7},{8,10},{15,18}}, new int[]{23,24})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{2,6},{2,7},{8,10},{15,18}}, new int[]{16,17})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{2,6},{2,7},{8,10},{15,18}}, new int[]{2,4})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3}}, new int[]{2,4})));
        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{2,9})));
    }
    static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] { newInterval };

        List<int[]> ans = new ArrayList<>();
        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                //newInterval after current Interval
                ans.add(in);
            } else if (in[0] > newInterval[1]) {
                //newInterval before current Interval
                ans.add(newInterval);
                newInterval = in;
            } else {
                //overlap
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(newInterval[1], in[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
