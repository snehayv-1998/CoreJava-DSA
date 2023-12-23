package binarySearch;

import java.util.Arrays;

public class KokoBananaEating {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/koko-eating-bananas/
         */
        System.out.println("KokoBananaEating :"+ numberOfTaskPerHour(new int[]{30,11,23,4,20},5));
        //using binary search
        System.out.println("KokoBananaEating :"+ numberOfTaskPerHourUsingBinarySearch(new int[]{805306368,805306368,805306368},1000000000));
    }
    /*
    issue with this approach is it will give time limit exceed for large number of data set.
   */
    static int numberOfTaskPerHour(int[] nums, int maxHour){
        Arrays.sort(nums);
        for(int i=1;i<=nums[nums.length-1];i++){
            int totalHour = totalHour(nums,maxHour,i);
            if(totalHour!=-1){
                return i;
            }
        }
        return 0;
    }

    static int totalHour(int[] nums, int maxHour, double numTaskPerHour){
        int totalHour=0;
        for(int i=0;i<nums.length;i++){
            totalHour+=  Math.ceil((double) nums[i]/numTaskPerHour);
            if(totalHour>maxHour){
                return -1;
            }
        }
        return totalHour;
    }
    static int numberOfTaskPerHourUsingBinarySearch(int[] nums,int maxHour){
        Arrays.sort(nums);
        int low= 1;
        int high= nums[nums.length-1];
        while(low<=high){
            int mid= low+(high-low)/2;
            int totalHour = totalHour(nums,mid);
            if(totalHour<=maxHour){
                high=mid-1;
            }else{
                low= mid+1;
            }
        }
        return low;
    }

  static int totalHour(int[] nums, double numTaskPerHour){
        int totalHour=0;
        for(int i=0;i<nums.length;i++){
            totalHour+=  Math.ceil((double) nums[i]/numTaskPerHour);
        }
        return totalHour;
    }
}
