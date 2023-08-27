import java.util.Locale;

public class QPalindrome {
    public static void main(String[] args) {
        String s = "adda";
       /* System.out.printf("\n\nGiven string %s is palindrome :  %b\n\n", s,palindrome(s));
        int i =10;*/
        System.out.printf("\n\nGiven string %s is palindrome :  %b\n\n", -121,isPalindrome(-121));
    }
    private static boolean palindrome(String s) {
        int i = 0;
        int length =  s.length();
        while (i < length/2){
            if(s.charAt(i) != s.charAt(length-1-i)){
                return false;
            }
            i +=1;
        }return true;
    }
    /*
    Given an integer x, return true if x is a palindrome, and false otherwise.
    Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.
    Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     */
    public static boolean isPalindrome(int x) {
        int revers = 0;
        int temp =  x;
        while (x > 0) {
            int digit = x % 10;
            revers = revers*10 + digit;
            x /= 10;
        }
        if(revers==temp){
            return true;
        }
        return false;
    }

        public static boolean palindrome(int x) {
            // Convert the integer to a string
            String str = Integer.toString(x);

            // Create a StringBuilder to reverse the string
            StringBuilder reversed = new StringBuilder(str).reverse();

            // Compare the original string with the reversed string
            return str.equals(reversed.toString());
        }

}
