public class QReverseNum {
    public static void main(String[] args) {
        int n =996587554;
        int reversedNum = 0;
        while (n>0){
            reversedNum = reversedNum*10+(n%10);
            n= n/10;
        }
        System.out.println("Reversed number of 996587554 is : "+reversedNum);
    }
}
