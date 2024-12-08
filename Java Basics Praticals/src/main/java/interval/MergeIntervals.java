package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /*
    https://leetcode.com/problems/merge-intervals/description/
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{2,7},{8,10},{15,18}})));
    }
    static int[][] merge(int[][] intervals) {
        if (intervals.length < 1)
            return intervals;
        Arrays.sort(intervals, (i1,i2)->i1[0]-i2[0]);
        System.out.println(Arrays.deepToString(intervals));
        int[] in = intervals[0];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (in[1] < intervals[i][0]) {
                ans.add(in);
                in = intervals[i];
            } else {
                in[1] = Math.max(in[1], intervals[i][1]);
            }
        }
        ans.add(in);
        return ans.toArray(new int[ans.size()][]);
    }
}
