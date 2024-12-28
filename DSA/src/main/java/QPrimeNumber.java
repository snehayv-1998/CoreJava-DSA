public class QPrimeNumber {
    /* without method
    public static void main(String[] args) {
        int n =21;
        boolean flag = true;
        for (int i=2;i<=n/2;i++){
            if(n%i ==0) {
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println(n+" is prime!!");
        else
            System.out.println(n +" is not a prime!!");

    }
     */
    /*With method- */
    public static void main(String[] args) {
        int n =11;
        int c = 2;
        if(isPrime(n, c))
            System.out.println(n+" is prime!!");
        else
            System.out.println(n +" is not a prime!!");
    }

    private static boolean isPrime(int n, int c) {
        if(n==1 || n==0)
            return false;
        while (c*c<=n){
            if(n % c ==0)
               return false;
            c++;
        }
        return true;
    }

}
