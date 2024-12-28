package interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
    public static void main(String[] args) {
        System.out.println(minMeetingRoom(new int[][]{{1,30},{2,6},{13,15},{31,30}}));
    }
    static int minMeetingRoom(int[][] intervals){
        int room=0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>priorityQueue = new PriorityQueue<>();
        for (int[] interval:intervals) {
            if (!priorityQueue.isEmpty() && priorityQueue.peek() <= interval[0]) {
                priorityQueue.poll();
            } else {
                room++;
            }
            priorityQueue.add(interval[1]);
        }
        return room;
    }
}
