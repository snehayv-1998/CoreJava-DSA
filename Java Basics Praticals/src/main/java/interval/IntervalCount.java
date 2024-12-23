package interval;

import java.util.Map;
import java.util.TreeMap;

public class IntervalCount {
    TreeMap<Integer,Integer>intervalCount;
    int totalCount;

    public IntervalCount() {
        intervalCount = new TreeMap<>();
        totalCount = 0;
    }

    public void add(int left, int right) {
        /*while is need for this scenario :
        {3,5}-3
        {6,9}-3+4
        {4,10}-> {3,10}-8 here 4 is lies in prev to prev interval
         */
        while (intervalCount.floorEntry(right) != null && intervalCount.floorEntry(right).getValue() >= left) {
            Map.Entry<Integer, Integer> floor = intervalCount.floorEntry(right);
            intervalCount.remove(floor.getKey());
            totalCount -= floor.getValue() - floor.getKey() +1;
            left = Math.min(floor.getKey(), left);
            right = Math.max(floor.getValue(), right);
        }
        intervalCount.put(left, right);
        totalCount += ((right - left) + 1);

    }

    public int count() {
        return totalCount;
    }

    public static void main(String[] args) {
        IntervalCount intervalCount1 = new IntervalCount();
        //["CountIntervals","count","add","add","count","count","add"]
        //[[],[],[39,44],[13,49],[],[],[47,50]]
        //[null,0,null,null,37,37,null]
        System.out.println(intervalCount1.count());
        intervalCount1.add(39,44);
        intervalCount1.add(13,49);
        System.out.println(intervalCount1.count());
        System.out.println(intervalCount1.count());
        intervalCount1.add(47,50);


        System.out.println("---------------------------------------");
        /*
        Input:["CountIntervals","add","add","count","add","count"]
              [[],[2,3],[7,10],[],[5,8],[],[1,11],[]]
        output: [null,null,null,6,null,8,null,11]
         */
        IntervalCount intervalCount2 = new IntervalCount();
        intervalCount2.add(2,3);
        intervalCount2.add(7,10);
        System.out.println(intervalCount2.count());
        intervalCount2.add(5,8);
        System.out.println(intervalCount2.count());
        intervalCount2.add(8,11);

        System.out.println(intervalCount2.count());
        intervalCount2.add(1,11);
        System.out.println(intervalCount2.count());
    }
}
