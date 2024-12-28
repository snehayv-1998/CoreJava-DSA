package stacksAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SliddingWindow {
    public static void main(String[] args) {
        System.out.println("Sliding window: "+ Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }
    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int rs=0;
        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peek()==i-k)
                deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }

            deque.offer(i);
            if(i>=k-1){
                res[rs++]=nums[deque.peek()];
            }
        }
        return res;
    }
}
