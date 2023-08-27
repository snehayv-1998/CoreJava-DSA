public class QPatterns {
    /*
    Steps to solve patterns:
    1. Identify the number rows needed. This will the length of outer loop
    2. Identify for each row how many columns are present.
    3. Print the required symbol.
     */
    public static void main(String[] args) {
      pattern3(3);
    }

    /*
    Pattern 1:
    *
    **
    ***

     */

    private static void pattern1(int n) {
        for(int row =1; row<=n ;row++){
            for (int col = 1; col<=row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
    Pattern 2:
    1 2 3
    1 2
    1
     */
    private static void pattern2(int n) {
        for(int row =0; row<=n ;row++){
            for (int col = 1; col<=n-row; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    /*
    Pattern 3:
    *
    **
    ***
    ****
    ***
    **
    *

     */
    private static void pattern3(int n) {
        for(int row =0; row<=2*n ;row++){

            int colMaxSize = row>n ? 2*n-row :row;

            for (int col = 1; col<=colMaxSize ; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    /*
    Pattern 4:
       1
     2 1
   3 2 1
     */
    private static void pattern4(int n) {
        for(int row =1; row<=n ;row++){
            for (int j = 1; j <= n - row; j++) {
                System.out.print("  ");
            }
            for (int col = row; col >=1; col--){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
