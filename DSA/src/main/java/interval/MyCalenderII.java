package interval;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyCalenderII {
    TreeMap<Integer,Integer> booking = new TreeMap<>();

    public void MyCalendarII() {

    }

    public boolean book(int startTime, int endTime) {
       int counter=0;
       booking.put(startTime,booking.getOrDefault(startTime,0)+1);
       booking.put(endTime,booking.getOrDefault(endTime,0)-1);
       for (Map.Entry<Integer,Integer> entry:booking.entrySet()){
           counter+=entry.getValue();
           if(counter>2){
               booking.put(startTime,booking.getOrDefault(startTime,0)-1);
               booking.put(endTime,booking.getOrDefault(endTime,0)+1);
               if(booking.get(startTime)==0){
                   booking.remove(startTime);
               }
               if(booking.get(endTime)==0){
                   booking.remove(endTime);
               }
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        MyCalenderII calendar = new MyCalenderII();
        System.out.println(calendar.book(10, 20)); // true
        System.out.println(calendar.book(50, 60)); // true
        System.out.println(calendar.book(10, 40)); // true
        System.out.println(calendar.book(5, 15));  // false
        System.out.println(calendar.book(5, 10));  // true
        System.out.println(calendar.book(25, 55)); // true
    }
}
