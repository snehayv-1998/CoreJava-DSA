package binarySearch;

public class PeekElement {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/find-peak-element/description/
         */
        System.out.println("Peek element : "+ findPeakElement(new int[]{1,2,3,1}));
    }
    static int findPeakElement(int[] nums) {
        if(nums==null) return -1;
        int n = nums.length;
        if(n ==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int l=1;
        int h=n-2;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m-1]<nums[m] && nums[m]>nums[m+1]) return m;
            else if(nums[m]>nums[m-1]) l=m+1;
            else if(nums[m]>nums[m+1]) h=m-1;
            else l=m+1;
        }
        return -1;
    }
}
