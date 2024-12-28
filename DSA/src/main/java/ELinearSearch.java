import java.util.Arrays;

public class ELinearSearch {
    public static void main(String[] args) {

        //linear search a int in int array
        int[] array = {1, 92, -75, -99, 99999999,8,10};
        int target=8;
        boolean flag =false;

        for (int i =0 ; i <array.length ; i++){
            if(array[i]==target) {
                flag = true;
                break;
            }
        }

        if (flag)
            System.out.println("\n\nTarget "+target+" is present in  array "+ Arrays.toString(array));
        else
                System.out.println("\n\nTarget "+target+" is not present in array "+ Arrays.toString(array));

        System.out.println("\n\n**********************************************************************");

        //linear search a string in a arrays of string
        String[] stringArray = {"aaa","bbb","ccc","ddd"};
        String targetString = "ccnc";
        flag =false;

        for (int i =0 ; i <stringArray.length ; i++){
            if(stringArray[i]==targetString) {
                flag = true;
                break;
            }
        }

        if (flag)
            System.out.println("\n\nTarget "+targetString+" is present in  array "+ Arrays.toString(stringArray));
        else
            System.out.println("\n\nTarget "+targetString+" is not present in array "+ Arrays.toString(stringArray));

        System.out.println("\n\n**********************************************************************");

        //linear search a char in string
        String string = "Hello!!";
        char targetChar = '!';
        flag =false;

        for (int i =0 ; i <string.length() ; i++){
            if(targetChar == string.charAt(i)) {
                flag = true;
                break;
            }
        }

        if (flag)
            System.out.println("\n\nTarget "+targetChar+" is present in string "+ string);
        else
            System.out.println("\n\nTarget "+targetChar+" is not present in string "+ string);

        System.out.println("\n\n**********************************************************************");

    }

}
