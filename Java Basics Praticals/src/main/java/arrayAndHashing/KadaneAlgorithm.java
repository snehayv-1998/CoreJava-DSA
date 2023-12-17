package arrayAndHashing;

import java.util.Arrays;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        System.out.println("maxSubArray : "+maxSubArray(new int[]{-2,9,0,1,-1,1,2}));
        System.out.println("maxSubArrayList : "+ Arrays.toString(maxSubArrayList(new int[]{-2,9,0,1,-1,1,2})));
    }
    static int maxSubArray(int[] nums) {
        int max =  Integer.MIN_VALUE;
        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            max = Math.max(max,sum);
            if(sum<0)
                sum =0;
        }
        return max;
    }

    static int[] maxSubArrayList(int[] nums) {
        int max =  Integer.MIN_VALUE;
        int sum =0;
        int ansStart = 0;int ansEnd =0;
        int start=0;
        for(int i =0;i<nums.length;i++){
            if(sum<0){
                sum =0;
                start = i;
            }
            sum += nums[i];
            if (max<sum){
                max=sum;
                ansStart=start;
                ansEnd=i;
            }
        }
        return Arrays.copyOfRange(nums,ansStart,ansEnd+1);
    }

//    public int maxProduct(int[] nums) {
//    }
}
