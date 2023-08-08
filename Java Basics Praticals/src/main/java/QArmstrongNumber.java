/*Find all 3 digit armstrong number*/
public class QArmstrongNumber {
    public static void main(String[] args) {
        for (int i = 100;i<=1000;i++){
            int sum =0;
            int temp =i;
            while (temp>0){
                int digit = temp%10;
                sum += digit*digit*digit;
                temp/=10;
            }
            if (sum == i)
                System.out.println(i+" is armstrong number.");
        }
    }
}
