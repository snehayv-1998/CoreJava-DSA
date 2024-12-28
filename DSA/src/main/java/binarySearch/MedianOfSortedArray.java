package binarySearch;

public class MedianOfSortedArray {
    /*
    https://leetcode.com/problems/median-of-two-sorted-arrays/description/
     */
    public static void main(String[] args) {
        System.out.println("Median of sorted arrays: "+findMedianSortedArrays(new int[]{3},new int[]{-2,-1}));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n= n1+n2;
        int indexOfEle2= n/2;
        int indexOfEle1=indexOfEle2-1;
        int ele1=Integer.MIN_VALUE;int ele2=Integer.MIN_VALUE;int cnt=0;
        int i=0;int j=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                if(cnt==indexOfEle2){
                    ele2=nums1[i];
                    break;
                }
                if(cnt==indexOfEle1) ele1=nums1[i];
                cnt++;i++;
            }else{
                if(cnt==indexOfEle2){
                    ele2=nums2[j];
                    break;
                }
                if(cnt==indexOfEle1) ele1=nums2[j];
                cnt++;j++;
            }
        }
        while(i<n1 && ele2 ==Integer.MIN_VALUE){
            if(cnt==indexOfEle2){
                ele2=nums1[i];
                break;
            }
            if(cnt==indexOfEle1) ele1=nums1[i];
            cnt++;i++;
        }
        while(j<n2  && ele2 == Integer.MIN_VALUE){
            if(cnt==indexOfEle2){
                ele2=nums2[j];
                break;
            }
            if(cnt==indexOfEle1) ele1=nums2[j];
            cnt++;j++;
        }
        if(n%2==1) return (double)ele2;
        return (((double) ele2+ele1)/2.0);
    }
}
