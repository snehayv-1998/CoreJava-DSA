package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EFunctionalInterface {
    public static void main(String[] args) {
        //square
        Function<Integer,Integer> function = integer -> integer*integer;
        System.out.println("Square of 2 : "+function.apply(2));
        System.out.println("Square of 100 : "+function.apply(100));

        //odd or even
        Predicate<Integer> predicate = integer -> integer%2 ==0;
        System.out.println(" 2 is even :"+predicate.test(2));
        System.out.println(" 3 is even :"+predicate.test(3));

        Consumer<Integer> consumer = integer -> System.out.println("Inside consumer method : "+integer);
        consumer.accept(15);
    }

}
