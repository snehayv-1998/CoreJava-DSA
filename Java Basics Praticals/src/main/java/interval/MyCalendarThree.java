package interval;

import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {
    TreeMap<Integer, Integer> booking = new TreeMap<>();

    public MyCalendarThree() {

    }

    public int book(int startTime, int endTime) {
        int counter = 0;
        int maxOverLap = 0;
        booking.put(startTime, booking.getOrDefault(startTime, 0) + 1);
        booking.put(endTime, booking.getOrDefault(endTime, 0) -1);
        for (int entry : booking.values()) {
            counter += entry;//counter holds the number of event present in calendar at that particular time
            maxOverLap = Math.max(maxOverLap, counter);
        }
        return maxOverLap;
    }

    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        System.out.println(calendar.book(10, 20)); // 1
        System.out.println(calendar.book(50, 60)); // 1
        System.out.println(calendar.book(10, 40)); // 2
        System.out.println(calendar.book(5, 15));  // 3
        System.out.println(calendar.book(5, 10));  // 3
        System.out.println(calendar.book(25, 55)); // 3
    }

}