package recursionAndBacktracking;

public class BasicRecursionPattern {
    public static void main(String[] args) {

        int i = 1;
        int n = 5;

        //linear parameterized:
        System.out.println("\nlinearParameterizedRecursion :");
        linearParameterizedRecursion(i,n);

        //functional recursion
        System.out.println("\nlinearFunctionalRecursion :");
        linearFunctionalRecursion(n);

        //backtracking recursion

        //multiple recursion call
        System.out.println("\nFibonacci :"+ fibonacci(n));
        //
        System.out.println("\nFibonacci sum :"+ fibonacciSum(n));
    }

    private static void linearParameterizedRecursion(int i, int n) {
        if(i > n) return;
        System.out.print(i);
        linearParameterizedRecursion(i+1,n);
    }

    private static void linearFunctionalRecursion(int n) {
        if(n == 0) return;
        System.out.print(n);
        linearFunctionalRecursion(n-1);
    }

    public static int fibonacci(int n) {
        // Base case
        if (n <= 1) {
            return n;
        } else {
            // Recursive case
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static int fibonacciSum(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += fibonacci(i);
        }
        return sum;
    }
}
