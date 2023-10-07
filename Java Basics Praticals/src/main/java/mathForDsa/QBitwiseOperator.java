package mathForDsa;

import java.util.Arrays;

public class QBitwiseOperator {
    public static void main(String[] args) {
        //find odd or not
        System.out.println("odd number:"+oddNumber());
        //find unique number in array: this works only if numbers in array repeats twice
        System.out.println("unique element: " + getUnique());
        //find the ith bit of a number
        System.out.println("ithBit: "+ithBit());
        //set a bit of a number
        System.out.println("After setting ith bit: "+setIthBit());
        //reset ith bit
        System.out.println("After setting ith bit: "+resetIthBit());
        /*
        Write a function that takes the binary representation of an
        unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
         */
        System.out.println("Total number of 1: "+hammingWeight(-8));
        // a^b
        System.out.println("");
        //number of digit
        System.out.println("Number of digit : "+(int)(Math.log(10)/Math.log(2)+1));
        //number is a power of 2 or not
        //sum of nth row of pascal triangle
        //xor until a given number
        {
            /*
        Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
        To flip an image horizontally means that each row of the image is reversed.
        For example, flipping [1,1,0] horizontally results in [0,1,1].
        To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
        For example, inverting [0,1,1] results in [1,0,0].
        Input: image = [[1,1,0],[1,0,1],[0,0,0]]
        Output: [[1,0,0],[0,1,0],[1,1,1]]
        case2: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
        Expected:[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
         */
            int[][] input = {{1, 1, 0,0}, { 0,1, 1,0}, {0, 0, 0,1},{1,0,1,0}};
            int res[][] = flipAndInvertImage(input);
            System.out.println("flipAndInvertImage : ");
            for (int[] output: res)
                System.out.println( Arrays.toString(output));
        }

    }

    private static boolean oddNumber() {
        int input = 3;
        if((input & 1) == 1) //Ex: input= 3-> 11 ,  11&01= 1  return true, input= 2-> 10 ,  10&01= 0 return false
            return true;
        return false;
    }

    private static int getUnique() {
        int[] array = {2, 3, 3, 2, 5};
        int unique = 0;
        for (int i : array) {
            unique ^= i;
        }
        return unique;
    }

    private static int ithBit() {
        /*
        input = 16 --> 10000
        16 >> 4
        00001(all bits are moved over 4 spots, therefore
        &                   the bit you want is at the end)
        00001 (0 means it will always be 0,
        =1                   1 means that it will keep the old value)
         */
        int input = 16;
        int bitPosition = 4;
        return (input>>bitPosition) &1;
    }
    private static int setIthBit() {
        /* set ith bit to 1
         */
        int input =8;
        int bitPosition = 2;
        return input | (1<<(bitPosition-1));
    }
    private static int resetIthBit(){
        /* set ith bit to 0
         */
        int input =8;
        int bitPosition = 3;
        return input & (0<<(bitPosition-1));
    }
    public static int hammingWeight(int n) {
        int counter =0;
        while(n!=0){
            if((n & 1)==1) counter +=1;
            n = n>>>1;
        }
        return counter;
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for(int i =0 ;i<image.length;i++){
            for(int j =0 ;j<(image[i].length+1)/2;j++){ // imp: (image[i].length+1) this is used handle flipping the odd numbers middle digit
                int temp = image[i][j]^1;
                image[i][j]= image[i][image[i].length-j-1]^1;
                image[i][image[i].length-j-1] = temp;
            }
        }
        return image;
    }
}