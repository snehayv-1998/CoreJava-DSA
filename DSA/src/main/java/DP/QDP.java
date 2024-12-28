package DP;

import java.util.Arrays;
import java.util.Collection;

public class QDP {
    public static void main(String[] args) {
        int[][] points = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("\n****************minPathSum  :"+ minPathSum(points));
      /*int days = 3;
        System.out.println("\n****************Ninja Training recursion :"+ trainRecursion(days-1,-1,points));
        int[][] dp = new int[3][3];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        System.out.println("\n****************Ninja Training memoization :"+ trainMemoization(days -1,-1, points,dp));
        System.out.println("\n****************Ninja Training tabulation :"+ trainTabulation(days-1,points));

       */
    }
    /*
        You are climbing a staircase. It takes n steps to reach the top.
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        Example 1:
        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
        Example 2:
        Input: n = 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
     */
    public int climbStairs(int n) {
        if(n==0)return 1;
        if(n==1)return 1;
        int prev = 1;
        int prev2 = 1;
        int cur =0;
        for(int i = 2; i<=n; i++){
            cur=prev+prev2;
            prev2= prev;
            prev = cur;
        }
        return cur;
    }
    //https://www.codingninjas.com/studio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

   // https://leetcode.com/problems/house-robber/submissions/
    //memoization
   public int rob(int[] nums) {
       int n = nums.length;
       int[] dp =new int[n];
       Arrays.fill(dp,-1);
       return maxMoney(n-1,nums,dp);
   }
    int maxMoney(int i,int[]nums,int[]dps){
        if(i==0) return nums[i];
        if(i<0)return 0;
        if(dps[i] != -1)return dps[i];
        int pick = nums[i]+maxMoney(i-2,nums,dps);
        int notPick = maxMoney(i-1,nums,dps);
        dps[i]=Math.max(pick,notPick);
        return dps[i];
    }
    //tabulation
    public int robT(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] dp =new int[n];
        Arrays.fill(dp,-1);
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int pick = nums[i]+dp[i-2];
            int notPick = dp[i-1];
            dp[i]=Math.max(pick,notPick);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    //code optimization
    public int robOpt(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int max = Integer.MIN_VALUE;
        int prev2 = nums[0];
        int prev = Math.max(nums[0],nums[1]);
        int cur = nums[2];
        for(int i=2;i<n;i++){
            int pick = nums[i]+prev2;
            int notPick = prev;
            cur=Math.max(pick,notPick);
            max = Math.max(max,cur);
            prev2 = prev;
            prev = cur;
        }
        return max;
    }

    /*
    A thief needs to rob money in a street. The houses in the street are arranged in a circular manner.
    There fore the first and the last house are adjacent to each other. The security system in the street
    is such that if adjacent houses are robbed, the police will get notified.
     Given an array of integers Arr which represents money at each house,
    we need to return the maximum amount of money that the thief can rob without alerting the police.
     */

    /*
    A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities (Running,
    Fighting Practice, or Learning New Moves) each day. There are merit points associated with performing
    an activity each day. The same activity can’t be performed on two consecutive days. We need to find the
    maximum merit points the ninja can attain in N Days.We are given a 2D Array POINTS of size ‘N*3’ which
    tells us the merit point of specific activity on that particular day. Our task is to calculate the maximum
     number of merit points that the ninja can earn
     */

    static int trainRecursion(int days, int last, int [][] points){


        if(days == 0){
            int max =0;
            for(int a =0;a<3;a++){
                if(a!=last){
                    max = Math.max(max,points[days][a]);
                }
            }
            return max;
        }
        int max =0;
        for(int at=0;at<3;at++){
            if(at!=last){
                max= Math.max(max,points[days][at]+trainRecursion(days-1,at, points));
            }
        }
        return max;
    }
    static int trainMemoization(int days, int last, int [][] points,int[][]dp){
        // If the result is already calculated, return it
        if (dp[days][last] != -1) return dp[days][last];
        if(days == 0){
            int max =0;
            for(int a =0;a<3;a++){
                if(a!=last){
                    max = Math.max(max,points[days][a]);
                }
            }
            return max;
        }
        int max =0;
        for(int at=0;at<3;at++){
            if(at!=last){
                    max= Math.max(max,points[days][at]+trainMemoization(days-1,at, points,dp));
                    dp[days][at]=max;
            }
        }

        return dp[days][last];
    }
    static int trainTabulation(int days, int [][] points){
        int max =0;
        int[][] dp = new int[days][3];
        for(int i =0;i<3;i++){
            dp[0][i] = points[0][i];
        }
        int last=0;
        for(int day=0;day<days;day++){
            for(int at=0;at<3;at++){
                if(at!=last){
                        max= Math.max(max,points[days][at]+dp[days-1][last]);
                        dp[days][at] =max;
                }
            }
        }
        return max;
    }

   //https://leetcode.com/problems/unique-paths/description/
        public int uniquePaths(int m, int n) {
            if(m<0||n<0)
                return 0;
            if(m ==0 && n==0){
                return 1;
            }
            int dps[][] = new int[m][n];
            for(int[] arrs: dps){
                Arrays.fill(arrs,-1);
            }
            return paths(m-1,n-1,dps);
        }
        int paths(int m,int n, int [][] dps){
            if(m<0||n<0)
                return 0;
            if(m ==0 && n==0){
                return 1;
            }
            if(dps[m][n]!=-1) return dps[m][n];
            int left = paths(m,n-1,dps);
            int up = paths(m-1,n,dps);
            dps[m][n] = left + up;
            return dps[m][n] ;
        }
        //https://leetcode.com/problems/unique-paths-ii/description/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m<=0 || n<=0 )return 0;
        int[][] dps = new int[m][n];
        for(int[]dp :dps){
            Arrays.fill(dp,-1);
        }
        return uniquePathsWithObstaclesMemoization(m-1,n-1,dps,obstacleGrid);
    }
    int uniquePathsWithObstaclesMemoization(int m,int n,int[][]dp,int[][]obstacleGrid){
        if(m<0 || n<0 )return 0;
        if(obstacleGrid[m][n] == 1)return 0;
        if(m==0 && n==0)return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        int left = uniquePathsWithObstaclesMemoization(m,n-1,dp,obstacleGrid);
        int up = uniquePathsWithObstaclesMemoization(m-1,n,dp,obstacleGrid);
        return dp[m][n] = left+up;
    }
    //https://leetcode.com/problems/minimum-path-sum/
    static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m<=0 || n<=0 )return 0;
        int[][] dps = new int[m][n];
        for(int[]dp :dps){
            Arrays.fill(dp,-1);
        }
        return minPathSumMemoization(m-1,n-1,dps,grid);
    }
    static int minPathSumMemoization(int m, int n, int[][] dp, int[][] grid){
        if(m<0 || n<0 )
            return  (int) Math.pow(10, 9); // If we're out of bounds, return a large value
        if(m==0 && n==0)
            return grid[m][n];
        if(dp[m][n]!=-1)
            return dp[m][n];
        int left =  grid[m][n] +minPathSumMemoization(m,n-1,dp,grid);
        int up =  grid[m][n] + minPathSumMemoization(m-1,n,dp,grid);
        return dp[m][n] = Math.min(left,up);
    }
}
