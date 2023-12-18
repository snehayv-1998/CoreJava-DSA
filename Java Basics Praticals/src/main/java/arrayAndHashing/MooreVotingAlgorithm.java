package arrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MooreVotingAlgorithm {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/majority-element/description/
         */
        System.out.println("\nmajorityElement: "+majorityElement(new int[]{1,2,4,3,1,1}));
        /*
        https://leetcode.com/problems/majority-element-ii/description/
         */
        System.out.println("\nmajorityElement n/3: "+majorityElementN3(new int[]{1,2,4,3,5,1}));
        System.out.println("majorityElement n/3: "+majorityElementN3(new int[]{1,2}));
        System.out.println("majorityElement n/3: "+majorityElementN3(new int[]{1,5,5,5,2,1}));
    }
    /*
    Initialize 2 variables:
    Count –  for tracking the count of element
    Element – for which element we are counting
    Traverse through the given array.
    If Count is 0 then store the current element of the array as Element.
    If the current element and Element are the same increase the Count by 1.
    If they are different decrease the Count by 1.
     */
    static int majorityElement(int[] array){
        int count=0;
        int element=0;
        for(int i =0 ;i<array.length;i++){
            if(count == 0){
                element=array[i];
                count++;
            } else if (element==array[i]) {
                count++;
            }else{
                count--;
            }
        }
        return element;
    }

    static List<Integer> majorityElementN3(int[] nums) {
        List<Integer>res = new ArrayList<>();
        int count1=0;int count2=0;int el1 =Integer.MIN_VALUE;int el2 =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(count1==0&& el2!=nums[i]){
                el1=nums[i];
                count1++;
            }
            else if(count2==0&&  el1!=nums[i]){
                el2=nums[i];
                count2++;
            }
            else if(el1==nums[i]) count1++;
            else if(el2==nums[i]) count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1=0;count2=0;
        for(int i=0;i<nums.length;i++){
            if(el1==nums[i]) count1++;
            if(el2==nums[i]) count2++;
        }
        int floor =nums.length/3;
        if(count1>floor) res.add(el1);
        if(count2> floor) res.add(el2);
        return res;
    }
}