public class QCountNums {
    //Q: find the number occurrence of a 6 in a 99956678
    public static void main(String[] args) {
        int a = 9;
        int n = 99956678;
        int counter=0;
        while (n>0){
            if(n%10 == a) counter++;
            n=n/10;
        }
        System.out.println("Number of occurrence of "+a+" is : "+counter);
    }
}
