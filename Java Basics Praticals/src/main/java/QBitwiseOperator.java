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
}