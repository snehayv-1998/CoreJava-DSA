package stacksAndQueue;

public class RainWaterTrapping {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/trapping-rain-water/description/
         */
        System.out.println("Rain water trap :" +trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    static int trap(int[] height) {
        int left =0;int right=height.length-1;
        int leftMax = 0;
        int rightMax = height[right];
        int res=0;
        while(left<=right){
            if(leftMax<=rightMax){
                if(height[left]<leftMax)
                    res += leftMax-height[left];
                else
                    leftMax = height[left];
                left++;
            }else{
                if(height[right]< rightMax)
                    res += rightMax-height[right];
                else
                    rightMax = height[right];
                right--;
            }
        }
        return res;
    }
}
