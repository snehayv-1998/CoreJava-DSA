package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /*
    https://leetcode.com/problems/subsets/description/
     */
    public static void main(String[] args) {
        System.out.println("Power set: "+subsets(new int[]{1,2,3}));
    }

    //using bit manipulation time complexity: 2^n * n space complexity: 2^n
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if(nums==null)return res;
        for(int num=0;num<Math.pow(2,nums.length);num++){
            List<Integer> sub=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if((num & (1<<i)) !=0) sub.add(nums[i]);
            }
            res.add(sub);
        }
        return res;
    }
}
