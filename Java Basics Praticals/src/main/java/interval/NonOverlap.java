package interval;

import java.util.Arrays;

public class NonOverlap {
    public static void main(String[] args) {
       // https://leetcode.com/problems/non-overlapping-intervals/
        System.out.println(eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }
    static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int prevEnd = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (prevEnd > interval[0]) {
                count++;
            }else prevEnd = interval[1];
        }
        return count;
    }
}
