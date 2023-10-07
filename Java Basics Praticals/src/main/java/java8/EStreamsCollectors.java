package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EStreamsCollectors {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("aasd","beee","occ","ccccc","ccccc");

        //toList
        System.out.println("\ntoList:");
        List<String> demoList = stringList.stream().collect(Collectors.toList());
        demoList.stream().forEach(System.out::println);

        //toMap
        System.out.println("\ntoMap:");
        Map<String,Integer> map = stringList.stream().collect(Collectors.toMap(Function.identity(),String::length,(val1, val2)->val1)); //to  handle duple key collision
        // Function.identity()-same has s->s(Function.identity() is just a shortcut for defining a function that accepts and returns the same value.)
        map.entrySet().stream().forEach(System.out::println);

        //toSet
        System.out.println("\ntoSet:");
        Set<String> demoSet = stringList.stream().collect(Collectors.toSet());
        demoSet.stream().forEach(System.out::println);

        //toCollection
        System.out.println("\ntoCollections:");
        List<String> linkedList = stringList.stream().collect(Collectors.toCollection(LinkedList::new));
        linkedList.stream().forEach(System.out::println);

        //collectingAndThen
        System.out.println("\ncollectingAndThen:");
        List<String> result = stringList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::<String> unmodifiableList));
        result.stream().forEach(System.out::println);

        //groupingBy
        System.out.println("\ngroupingBy:");
        Map<String, Long> stringFrequency = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        stringFrequency.entrySet().stream().forEach(System.out::println);

        //partitioningBy
        System.out.println("\npartitioningBy:");
        Map<Boolean, List<String>> startsWithA  = stringList.stream()
                .collect(Collectors.partitioningBy(s->s.startsWith("a")));
        startsWithA.entrySet().stream().forEach(System.out::println);

        //summarizingDouble/Long/Int
        System.out.println("\nsummarizingDouble:");
        DoubleSummaryStatistics doubleSummaryStatistics  = stringList.stream()
                .collect(Collectors.summarizingDouble(String::length));
        System.out.println(doubleSummaryStatistics);
        System.out.println("\nsummarizingInt:");
        IntSummaryStatistics intSummaryStatistics  = stringList.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(intSummaryStatistics.getCount());
        System.out.println("\nsummarizingLong:");
        LongSummaryStatistics longSummaryStatistics  = stringList.stream()
                .collect(Collectors.summarizingLong(String::length));
        System.out.println(longSummaryStatistics.getMin());



    }
}
