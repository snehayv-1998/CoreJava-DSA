import java.util.Scanner;

public class EInputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the input: ");
        int i = scanner.nextInt();
        System.out.println("Entered input is: "+i);

        System.out.println("Please enter the input: ");
        float f = scanner.nextFloat();
        System.out.println("Entered input is: "+f);
    }
}
