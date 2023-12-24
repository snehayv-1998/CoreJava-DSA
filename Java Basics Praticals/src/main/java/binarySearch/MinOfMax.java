package binarySearch;

import java.util.Arrays;

public class MinOfMax {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/magnetic-force-between-two-balls/description/
         */
        System.out.println("\nMin of max:"+maxDistance(new int[]{1,2,3,4,7},3));
        // the time complexity for the above is very high so use binary search
        System.out.println("\nMin of max using binary search:"+maxDistanceBinarySearch(new int[]{5,4,3,2,1,10000000},2));
    }
    /*
    time complexity : O(NlogN) + O(N *(max(position[])-min(position[])))
     */
   static int maxDistance(int[] position, int m) {
        if(position == null) return -1;
        Arrays.sort(position);
        for(int i=1;i<=(position[position.length-1]-position[0]);i++){
            if(!canWePlace(position,i,m)){
                return i-1;
            }
        }
        return -1;
    }
   static boolean canWePlace(int[] position,int minDist,int m){
        int lastPlaced=0;int placedThing=1;
        for(int i=1;i<position.length;i++){
            if(Math.abs(position[lastPlaced]-position[i])>=minDist){
                lastPlaced= i;
                placedThing ++;
            }
            if(placedThing>= m){
                return true;
            }
        }
        return false;
    }

   static int maxDistanceBinarySearch(int[] position, int m) {
        if(position == null) return -1;
        Arrays.sort(position);
        int low=1;int high= position[position.length-1]-position[0];
        while(low<=high){
            int mid= low+(high-low)/2;
            if(canWePlace(position,mid,m)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }
}
