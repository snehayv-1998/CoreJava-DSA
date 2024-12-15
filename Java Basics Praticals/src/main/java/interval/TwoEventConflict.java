package interval;

public class TwoEventConflict {
    public static void main(String[] args) {
        System.out.println(haveConflict(new String[]{"01:10","01:15"},new String[]{"01:16","01:19"}));
        System.out.println(haveConflict(new String[]{"01:10","01:15"},new String[]{"01:14","01:19"}));
        System.out.println(haveConflict(new String[]{"01:10","01:15"},new String[]{"01:15","01:19"}));
        System.out.println(haveConflict(new String[]{"14:13","22:08"},new String[]{"02:40","08:08"}));
    }
    static boolean haveConflict(String[] event1, String[] event2) {
        return event1[0].compareTo(event2[1]) <= 0 && event2[0].compareTo(event1[1]) <= 0;
    }
}
