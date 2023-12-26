package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*
    https://leetcode.com/problems/combination-sum/description/
     */
    public static void main(String[] args) {
        System.out.println("Combination of Sum: "+combinationSum(new int[]{2,3,6,7},7));
    }
   static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        if(candidates == null) return res;
        List<Integer> sub =new ArrayList<>();
        combSum(0,candidates,target,res,sub);
        return res;
    }
    static void combSum(int i, int[] candidates, int target, List<List<Integer>> res, List<Integer> sub){
        if(i==candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(sub));
            }
            return;
        }
        if(candidates[i]<=target){
            sub.add(candidates[i]);
            combSum(i,candidates,target-candidates[i],res,sub);
            sub.remove(sub.size()-1);
        }
        combSum(i+1,candidates,target,res,sub);
    }
}
