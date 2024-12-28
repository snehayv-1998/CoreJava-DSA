package binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/search-in-rotated-sorted-array/
         */
        System.out.println("Search in Rotated Sorted Array : "+search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println("Search in Rotated Sorted Array : "+search(new int[]{1,3},1));
    }
    static int search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m =l+(h-l)/2;
            if(nums[m]==target) return m;
            else if(nums[l]> nums[m]){
                if(nums[l]>=target && target>=nums[m]) l=m+1;
                else h=m-1;
            }else{
                if(nums[l]<=target && target<=nums[m]) h=m-1;
                else l=m+1;
            }
        }
        return -1;
    }
}
