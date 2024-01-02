package stacksAndQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreatestElement {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/next-greater-element-ii/submissions/
         */
        System.out.println("Next greatest element : "+ Arrays.toString(nextGreatest(new int[]{5, 7, 1, 2, 6, 0})));
          /*
           https://leetcode.com/problems/next-greater-element-i/
          */
        System.out.println("Next greatest element : "+ Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
    static int[] nextGreatest(int num[]){
        if(num==null) return null;
        int n = num.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2* n -1; i>=0; i--){
            while (!stack.empty()&& stack.peek()<=num[i%n]){
                stack.pop();
            }
            if(i<n){
                if(!stack.empty())
                    res[i%n]=stack.peek();
                else
                    res[i%n]=-1;
            }
            stack.push(num[i%n]);
        }

        return res;
    }

    static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums2==null) return null;
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i = n-1; i>=0; i--){
            while (!stack.empty()&& stack.peek()<=nums2[i]){
                stack.pop();
            }
            if(!stack.empty())
                res.put(nums2[i],stack.peek());
            else
                res.put(nums2[i],-1);

            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] =res.get(nums1[i]);
        }
        return ans;
    }

}
