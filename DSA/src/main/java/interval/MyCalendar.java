package interval;

import java.util.*;

public class MyCalendar {
    /*
    https://leetcode.com/problems/my-calendar-i/
    You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
    A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
    The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.

    boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a double booking.
    Otherwise, return false and do not add the event to the calendar.
     */
    TreeMap<Integer,Integer> cal = new TreeMap<>();
    public MyCalendar() {

    }
    public boolean book(int startTime, int endTime) {
        Map.Entry<Integer,Integer> prevBooking= cal.floorEntry(startTime);
        Map.Entry<Integer,Integer> nextBooking= cal.ceilingEntry(startTime);

        //current time should not intersect with previous and next timing
        //lesser than equal because previous end is excluded
        if((prevBooking==null || prevBooking.getValue()<=startTime) &&
                (nextBooking== null || nextBooking.getKey()>=endTime)) {
            cal.put(startTime, endTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(90, 200)); // return True
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already booked by another event.
        System.out.println(myCalendar.book(20, 30)); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
        System.out.println(myCalendar.book(21, 25)); // return false, It can not be booked because time 21 is already booked by another event.
        System.out.println(myCalendar.book(34, 75));
    }
}
