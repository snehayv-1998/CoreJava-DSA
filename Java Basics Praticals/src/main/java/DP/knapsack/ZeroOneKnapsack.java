package DP.knapsack;

public class ZeroOneKnapsack {
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
        System.out.println("memoization : "+memoization(val,wt,w,n));
        System.out.println("----------------------------------------------");

        //bottom up approach
        dp = new int[n+1][w+1];
        for (int i=0;i<=n;i++){
        for (int j=0;j<=w;j++) {
            if(i==0 || j==0) dp[i][j]=0;//initialize with base condition
        }
        }
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
        return Math.max(val[n-1]+recursiveWay(val,wt,w-wt[n-1],n-1),recursiveWay(val,wt,w,n-1));
    }
    public static int memoization(int[] val, int[] wt, int w, int n){
        //we can directly use n, w as a index to dp since it's size is n+1, w+1
        //where has in val[] and wt[] array we cant because it's size is n,w
        if(w==0|| n==0){
            return 0;
        }
        if(dp[n][w]!=-1)
            return dp[n][w];
        if(wt[n-1]>w){
            return dp[n][w]=memoization(val,wt,w,n-1);
        }
        return dp[n][w]= Math.max(val[n-1]+memoization(val,wt,w-wt[n-1],n-1),memoization(val,wt,w,n-1));
    }
    public static int tabulation(int[] val, int[] wt, int w, int n){
        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= w; j++) {
                if(wt[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j] =Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
            }
        }
        return dp[n][w];
    }
}
