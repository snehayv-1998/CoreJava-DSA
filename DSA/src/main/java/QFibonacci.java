public class QFibonacci {
    public static void main(String[] args) {
     int a = 0;
     int b = 1;
     int n=6;
     int counter =2;
     while (counter<=n){
         int temp = b;
         b +=a;
         a = temp;
         counter++;
     }
        System.out.println(n+"th fibonacci number is : "+b);
    }
}
