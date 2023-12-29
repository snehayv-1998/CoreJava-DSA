package recursionAndBacktracking;

public class Numbers {
    static int counter = 1;

    public static void main(String[] args) {
        numbers(1);
    }

    private static void number(int i) {
        System.out.println(counter);
        if (counter == i)
            return;
        counter++;
        number(i);
    }
    private static void numbers(int i) {
        System.out.println(i);
        if (i==6)
            return;
        numbers(i+1);
    }
}
