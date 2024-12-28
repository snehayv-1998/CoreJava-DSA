package arrayAndHashing;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/maximum-product-subarray/description/
         */
        System.out.println("maxProduct : "+maxProduct(new int[]{1,1,0,-2,5}));
        System.out.println("maxProduct : "+maxProduct(new int[]{-3,-1,-1}));
    }
    static int maxProduct(int[] nums) {
        int max =  Integer.MIN_VALUE;
        int prefix =1;
        int suf = 1;
        for(int i =0;i<nums.length;i++){
            if(prefix==0)prefix=1;
            if(suf ==0)suf =1;
            prefix = prefix * nums[i];
            suf= suf*nums[nums.length-i-1];
            max = Math.max(max,Math.max(prefix,suf));
        }
        return max;
    }
}
