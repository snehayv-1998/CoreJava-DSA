package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EStreams {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("hena",null,"bob","bob","hari");
        List<String> lastName = Arrays.asList("seena",null,"dhutt");

        //filter
        List<String> names= name.stream().filter(n->n!=null).collect(Collectors.toList());

        //foreach
        System.out.println("For each :" );
        names.stream().forEach(System.out::println);

        //map
        System.out.println("\nMap :" );
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        //flatmap
        List<List<String>> nameList = Arrays.asList(name,lastName);
        System.out.println("\nFlat Map :" );
        nameList.stream().flatMap(n-> n==null? Stream.empty():n.stream())
                .filter(n -> n!= null)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //distinct
        System.out.println("\nDistinct :" );
        name.stream().distinct().forEach(System.out::println);

        //count
        System.out.println("\nCount:" +name.stream().distinct().count());

        //limit
        System.out.println("\nlimit:");
        name.stream().limit(3).forEach(System.out::println);

        //min
        System.out.println("\nMin:");
        System.out.println(name.stream()
                        .filter(Objects::nonNull)
                        .min((val1,val2)->val1.compareTo(val2)).get());

        //max
        System.out.println("\nMax:");
        System.out.println(name.stream()
                .filter(Objects::nonNull)
                .max((val1,val2)->val1.compareTo(val2)).get());

        //reduce
        System.out.println("\nReduce(combines all the element in list to 1 list):");
        Optional<String> reducedVal = name.stream().reduce((val1, combinedVal)->val1+combinedVal);
        System.out.println(reducedVal.get());

        //toArray
        System.out.println("\nToArray:");
        Object array[] = name.stream().toArray();
        System.out.println(Arrays.asList(array));

        //sorted
        System.out.println("\nsorted:");
        name.stream().filter(n->n!=null).sorted().forEach(System.out::println);
        System.out.println("Reverse order:");
        name.stream().filter(n->n!=null).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("\nsorted using comparable:");
        name.stream().filter(n->n!=null).sorted((val1,val2)->val1.compareTo(val2)).forEach(System.out::println);
        System.out.println("Reverse order using comparable:");
        name.stream().filter(n->n!=null).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //skip
        System.out.println("\nSkip:");
        name.stream().skip(1).forEach(System.out::println);

        //anyMatch
        System.out.println("\nanyMatch");
        System.out.println("any name starts with b: "+name.stream().filter(n->n!=null).anyMatch(n->n.startsWith("b")));

        //concat 2 list to 1
        System.out.println("\nconcat:");
        Stream.concat(name.stream(),lastName.stream()).forEach(System.out::println);
    }
}
