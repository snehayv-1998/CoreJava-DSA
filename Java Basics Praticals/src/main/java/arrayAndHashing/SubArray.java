package arrayAndHashing;

public class SubArray
{
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/subarray-sum-equals-k/
         */
    }
    int subarraySum(int[] nums, int k) {
        int i=0;
        int j=0;
        int count = 0;
        int sum = 0;
        while(i ==nums.length || j==nums.length ){
            if(sum==k){
                count++;
                sum -=nums[i];
                i++;
            }else if(sum>k){
                sum -=nums[i];
                i++;
            }else{
                sum+=nums[j];
                j++;
            }
        }
        return count;
    }
}
