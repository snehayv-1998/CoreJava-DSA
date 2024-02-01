package Strings;

import java.util.Arrays;

public class QString {
    /*
    Uppercase Letters − A - Z having ASCII values from 65 - 90 where 65 and 90 are inclusive.
    Lowercase Letter − a - z having ASCII values from 97 - 122 where 97 and 122 are inclusive.
    Numeric values − 0 - 9 having ASCII values from 48 - 57 where 48 and 57 are inclusive.
     */



    public static void main(String[] args) {
        {
            /*
        A phrase is a palindrome if, after converting all uppercase letters into
        lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
        Alphanumeric characters include letters and numbers.
        Given a string s, return true if it is a palindrome, or false otherwise.
        Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.
         */
            String str = "A man, a plan, a canal: _Panama";

            System.out.println("\n\nBefore converting : "+str);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i= 0 ; i<str.length();i++){
                if(isAlphaNumeric(str.charAt(i)))
                    stringBuilder.append(toLowerCase(str.charAt(i)));
            }

            System.out.println("\n\nIs palindrome :" + palindrome(stringBuilder));
        }

        {
            /*
            You are given a string s and an integer array indices of the same length.
            The string s will be shuffled such that the character at the ith position
            moves to indices[i] in the shuffled string.Return the shuffled string.
            Example 1:
            Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
            Output: "leetcode"
            Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
             */
            String s = "codeleet";
            int[] indices = {4,5,6,7,0,2,1,3};
            char c[] = new char[s.length()];
            for (int i= 0 ; i<s.length();i++){
                c[indices[i]]= s.charAt(i);// ith position moves to indices[i]
                /*
                wrong ans:
                c[i]= s.charAt(indices[i]); this moves index[i] to i
                 */
            }
            System.out.println("\n\nBefore shuffling : "+s);
            System.out.println("After shuffling: "+ String.valueOf(c));
        }
        {
            /*
            Write a function that reverses a string. The input string is given as an array of characters s.
            You must do this by modifying the input array in-place with O(1) extra memory.
            Example 1:
            Input: s = ["h","e","l","l","o"]
            Output: ["o","l","l","e","h"]
             */
            char[] s = {'H','e','l','l','0'};
            System.out.println("\n\nBefore swapping : "+String.valueOf(s));
            swapWithoutTemp(s);
            System.out.println("After swapping : " +String.valueOf(s));
        }
    }

    private static void swapWithoutTemp(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            // Swap the characters at the start and end pointers
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];

            // Move the pointers towards each other
            start++;
            end--;
        }
    }

    public static char toLowerCase(char c) {
        if(c >= 'A' && c <= 'Z')  return (char) (c + 32);
        return c;
    }

    public static boolean isAlphaNumeric(char c) {
        return  (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')  || (c >= 'A' && c <= 'Z')? true : false;
    }

    public static boolean isUpper(char c) {
        return (c >= 'A' && c <= 'Z') ? true : false;
    }
    public  boolean isLower(char c) {
        return (c >= 'a' && c <= 'z') ? true : false;
    }

    private static boolean palindrome(StringBuilder s) {
        int i = 0;
        int length =  s.length();
        while (i < length/2){
            if(s.charAt(i) != s.charAt(length-1-i)){
                return false;
            }
            i +=1;
        }return true;
    }
}
