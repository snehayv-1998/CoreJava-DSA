import java.util.Arrays;

public class QEvenDigit {
    public static void main(String[] args) {
        int[] array = {1,92,-75,-99,99999999};
        int counter = 0;

        for(int a : array){
            //To handle negative numbers:
            if(a<0)
                a *= -1;

            if( getDigits(a) % 2 ==0)
               counter++;

        }

        System.out.println("\n Number of even digit elements in array "+ Arrays.toString(array)+" is :"+counter);
        System.out.println("\n\n**********************************************************************");
    }

   //general approach:
    private static int getDigit(int arrayElement) {
        int numberOfDigit = 0;
        while (arrayElement>0){
            numberOfDigit ++;
            arrayElement /= 10;
        }
        return numberOfDigit;
    }

    //optimized approach:
    private static int getDigits(int arrayElement) {
        return (int) Math.log10(arrayElement)+1;
    }
}
