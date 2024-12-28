package Strings;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static void main(String[] args) {
        String input = "a13b1b12c561c1a4";
        String output = rearrangeString(input);
        System.out.println(output);
    }
    public static String rearrangeString(String input) {
        StringBuilder result = new StringBuilder();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char currentChar = input.charAt(0);
        map.put(currentChar,0);
        int count = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + Character.getNumericValue(c);
            } else {
                map.put(currentChar,map.getOrDefault(currentChar,0)+count);
                if(result.toString().contains(currentChar+"")){
                    result.deleteCharAt(result.indexOf(currentChar+""));
                    result.append(currentChar);
                    if(map.get(currentChar)>0)
                        result.append(map.get(currentChar));
                }
                currentChar = c;
                count = 0;
            }
        }

        // Append the last character and its count

            if(result.toString().contains(currentChar+"")){
                result.deleteCharAt(result.indexOf(currentChar+""));
                result.append(currentChar);
                if(map.get(currentChar)>0)
                    result.append(map.get(currentChar));
            }
            result.append(currentChar).append(count);

        System.out.println("map:"+map);
        return result.toString();
    }
}
