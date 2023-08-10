import java.util.Arrays;

public class QMaxWealth {
    /*
    You are given an m x n integer grid accounts where accounts[i][j] is
    the amount of money the ith customer has in the jth bank. Return the wealth
    that the richest customer has.
    A customer's wealth is the amount of money they have in all their bank
    accounts. The richest customer is the customer that has the maximum wealth.
    Example 1:
    Input: accounts = [[9,1,8], [13,2,1]]
    Output: 18
    Explanation:
    1st customer has wealth = 9 + 1 + 8 = 18
    2nd customer has wealth 13+2+1=16
     */
    public static void main(String[] args) {
        int[][] customerAccounts = {
                             {9,1,8},
                             {13,2,1},
                             {25,1,1}
                           };
        int highestAmount =0;
        int[] richestCustomer = new int[1];
        for (int[] customer : customerAccounts){
            int totalWealth = 0;
            for (int account: customer)
                totalWealth += account;

            if(highestAmount<totalWealth) {
                highestAmount = totalWealth;
                richestCustomer = customer;
            }
        }
        System.out.println("\n\nRichest Customer is : "+Arrays.toString(richestCustomer) +" and their wealth is: "+highestAmount);
        System.out.println("\n***********************************************************************");
    }
}
