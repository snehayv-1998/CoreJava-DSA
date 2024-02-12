package sorting;

import java.util.Arrays;

public class ECyclicSort {
    public static void main(String[] args) {
        int a[] ={7,2,3,4,5,6,1};
        System.out.println("Before cyclic sort : "+ Arrays.toString(a));
        cyclicSort(a);
        System.out.println("After cyclic sort : "+Arrays.toString(a));
    }

    private static void cyclicSort(int[] a) {
        if(a == null) return;
        int i = 0;
        while (i<a.length){
            int correctIndex = i+1;
            if(a[i] != correctIndex || i != a.length-1){
                swap(a,i,correctIndex);
                i++;
            }else
                i++;
        }

    }

    private static void swap(int[] a, int i, int correctIndex) {
        int temp =a[i];
        a[i]=a[correctIndex];
        a[correctIndex] = temp;
    }

}
