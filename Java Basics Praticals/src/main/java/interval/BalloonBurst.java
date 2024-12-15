package interval;

import java.util.Arrays;

public class BalloonBurst {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}));
        System.out.println(findMinArrowShots(new int[][]{{1,3},{2,6},{3,7},{8,10},{15,18}}));
        System.out.println(findMinArrowShots(new int[][]{{1,3},{2,6},{4,7},{8,10},{15,18}}));
        System.out.println(findMinArrowShots(new int[][]{}));
    }
    static int findMinArrowShots(int[][] points) {
        if(points.length==0)return 0;
        Arrays.sort(points, (a, b) -> a[0]==b[0]?Integer.compare(a[1], b[1]):Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(points));
        int arrow = 1;
        int prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (prevEnd < points[i][0]) {
                arrow++;
                prevEnd = points[i][1];
           }else{
               prevEnd=Math.min(prevEnd,points[i][1]);
           }
        }
        return arrow;
    }
}
