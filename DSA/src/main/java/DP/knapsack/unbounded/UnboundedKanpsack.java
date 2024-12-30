package DP.knapsack.unbounded;

public class UnboundedKanpsack {
        static int[][] dp;
        public static void main(String[] args) {
            //item array here is divided into val[] and weight[]
            int[] val=new int[]{1,6,3,4};//profit of including the item
            int[] wt =new int[]{2,3,4,5};//weight of items
            int w=12;//bag capacity
            int n = val.length;//number of item
            System.out.println("recursiveWay : "+recursiveWay(val,wt,w,n));
            System.out.println("-----------------------------------------------");

            //topdown approach
            dp = new int[n+1][w+1];
            for (int i=0;i<=n;i++){
                for (int j=0;j<=w;j++) {
                    if(i==0 || j==0) dp[i][j]=0;
                    else dp[i][j]=-1;
                }
            }
            System.out.println("memoization : "+memoization(wt,val,w,n));
            System.out.println("----------------------------------------------");

            //bottom up approach
            dp = new int[n+1][w+1];
            System.out.println("tabulation : "+tabulation(val,wt,w,n));
            System.out.println("----------------------------------------------");


        }
        public static int recursiveWay(int[] val, int[] wt, int w, int n){
            if(w==0|| n==0){
                return 0;
            }
            if(wt[n-1]>w){
                return recursiveWay(val,wt,w,n-1);
            }
            return Math.max(val[n-1]+recursiveWay(val,wt,w-wt[n-1],n),recursiveWay(val,wt,w,n-1));
        }
        public static int memoization(int[] weights,int[] values, int capacity, int n){
            //we can directly use n, w as a index to dp since it's size is n+1, w+1
            //where has in val[] and wt[] array we cant because it's size is n,w
                // Base case: no items left or capacity is 0
                if (n == 0 || capacity == 0) return 0;

                // Return cached value if already computed
                if (dp[n][capacity] != -1) return dp[n][capacity];

                // If the current item's weight exceeds capacity, skip it
                if (weights[n - 1] > capacity) {
                    dp[n][capacity] = memoization(weights, values, capacity, n - 1);
                } else {
                    // Maximize between:
                    // 1. Excluding the current item
                    // 2. Including the current item (allow multiple uses)
                    dp[n][capacity] = Math.max(
                            memoization(weights, values, capacity, n - 1), // Exclude the current item
                            values[n - 1] + memoization(weights, values, capacity - weights[n - 1], n)
                            // Include the current item
                    );
                                                                   /*
                    difference between ub bound and bound is :
                    bound:  memoization(weights, values, capacity - weights[n - 1], n-1)
                    unbound: memoization(weights, values, capacity - weights[n - 1], n)
                    */
                }

                return dp[n][capacity];
        }
        public static int tabulation(int[] val, int[] wt, int w, int n){
            for (int i=1;i<=n;i++) {
                for (int j = 1; j <= w; j++) {
                    if(wt[i-1]>j)
                        dp[i][j]=dp[i-1][j];
                    else
                        dp[i][j] =Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                    /*
                    difference between ub bound and bound is :
                    bound: dp[i-1][j-wt[i-1]]
                    unbound:dp[i][j-wt[i-1]]
                     */
                }
            }
            return dp[n][w];
        }
    }
