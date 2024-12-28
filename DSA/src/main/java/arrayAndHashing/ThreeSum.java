package arrayAndHashing;

import java.util.*;

/*
3 Sum : Find triplets that add up to a zero
Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i,
and their sum is equal to zero.
No duplicates allowed.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition
of summing up to zero with i!=j!=k
Example 2:
Input: nums=[-1,0,1,0]
Output: Output: [[-1,0,1],[-1,1,0]]
Explanation: Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of
summing up to zero with i!=j!=k
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println("Better solution : "+threeSum(new int[]{1, 2, -2, 0, -1, 1}));
        System.out.println("Optimized solution : "+threeSumOptimized(new int[]{-2,0,0,1,1,1,2}));
    }
    /*
    there are 3 ways : Brute force(using 3 loops)
                       Better solution(using 2 loops)
                       optimised (2 pointer approach)
     */

    static Set<List<Integer>> threeSum(int[] nums) {
            int size = nums.length;
            Set<List<Integer>> uniqueRes = new HashSet<>();
            for(int i =0 ;i<size;i++){
                Set<Integer> set = new HashSet<>();
                for (int j = i+1; j<size;j++){
                    int third = -(nums[i]+nums[j]);
                    if(set.contains(third)){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], third);
                        list.sort(Comparator.naturalOrder()); //this need to remove duplicate result in uniqueRes
                        uniqueRes.add(list);
                    }
                    set.add(nums[j]);
                }
            }
            return uniqueRes;
    }
    static List<List<Integer>> threeSumOptimized(int[] nums){
            List<List<Integer>> res = new ArrayList<>();
            nums= Arrays.stream(nums).sorted().toArray();
            int n = nums.length;
            for (int i =0;i<n-2;i++){
                if(i!=0 && nums[i]== nums[i-1]) continue; // skip duplicate
                int j = i+1;
                int k = n-1;
                while (j<k){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum>0){
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while (j<k && nums[j+1]==nums[j]) j++; //skip duplicate
                        while (j<k && nums[k-1]==nums[k]) k--; //skip duplicate
                        k--;
                        j++;

                    }
                }

            }
            return res;
    }
}
