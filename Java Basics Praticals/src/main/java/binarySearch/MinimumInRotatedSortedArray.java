package binarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
         */
        System.out.println("Minimum in Rotated Sorted Array : "+findMin(new int[]{4,5,0,1,2,3}));
    }
    static int findMin(int[] nums) {
        if(nums ==null) return -1;
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[mid]){
                min = Math.min(min,nums[low]);
                low=mid+1;
            }else{
                min = Math.min(min,nums[mid]);
                high=mid-1;
            }
        }
        return min;
    }
}
