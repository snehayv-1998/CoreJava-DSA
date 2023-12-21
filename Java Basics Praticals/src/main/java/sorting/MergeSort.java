package sorting;

import java.util.ArrayList;

public class MergeSort {
    /*

     */
    public static void main(String[] args) {

    }
     int[] sortArray(int[] nums) {
        if(nums==null)return nums;
        return mergeSort(nums,0,nums.length-1);
    }
    int[] mergeSort(int[]nums,int s,int e){
        if(s>=e) return nums;
        int m = (s+e)/2;
        mergeSort(nums,s,m);
        mergeSort(nums,m+1,e);
        merge(nums,s,m,e);
        return nums;
    }
    void merge(int[]nums,int s,int m, int e){
        int l=s;
        int r=m+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(l<=m && r<=e){
            if(nums[l]>nums[r]){
                temp.add(nums[r]);
                r++;
            }else{
                temp.add(nums[l]);
                l++;
            }
        }
        while(l<=m){
            temp.add(nums[l]);
            l++;
        }
        while(r<=e){
            temp.add(nums[r]);
            r++;
        }
        for(int i = s;i<=e;i++){
            nums[i]= temp.get(i-s);
        }
    }
}
