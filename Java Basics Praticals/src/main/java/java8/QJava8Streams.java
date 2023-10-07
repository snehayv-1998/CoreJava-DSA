package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QJava8Streams {
    public static void main(String[] args) {
        {
            /*
            Given a string paragraph and a string array of the banned words banned,
            return the most frequent word that is not banned. It is guaranteed there
            is at least one word that is not banned, and that the answer is unique.
            The words in paragraph are case-insensitive and the answer should be returned in lowercase.
            Example 1:
            Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.",
            banned = ["hit"]
            Output: "ball"
             */
            System.out.println("mostCommonWord : "+mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
            System.out.println("str: "+beautySum("sdfefsss"));
        }
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        return Arrays.stream(paragraph.toLowerCase().split("\\W+"))
                .filter(s -> !bannedSet.contains(s))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(s->s.getValue())).get().getKey();

    }
    public static int beautySum(String s) {
        LongSummaryStatistics stat=   s.chars().mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(str->str,Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.summarizingLong(e->e.getValue()));

        return (int) (stat.getMax()-stat.getMin());

    }
}
