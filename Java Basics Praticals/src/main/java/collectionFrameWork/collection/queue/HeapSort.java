package collectionFrameWork.collection.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) throws Exception {
        System.out.println("************ heapsort:");
        int[] nums = {5, 3, 4, 2, 1};
        System.out.println("------------before: "+ Arrays.toString(nums));
        System.out.println("------------after: "+ Arrays.toString(sortArray(nums)));
    }
    static int[] sortArray1(int[] nums) {
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) pq.offer(n);
        while(!pq.isEmpty()) nums[i ++] = pq.poll();
        return nums;
    }
    static int[] sortArray(int[] nums) throws Exception {
        if(nums == null || nums.length == 0) return nums;

        List<Integer> heap = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            add(nums[i],heap);
        }
        return heapSort(heap);
    }
    static void swap(int a,int b, List<Integer> heap){
        int temp = heap.get(a);
        heap.set(a,heap.get(b));
        heap.set(b,temp);
    }
    static int parent(int index){
        return (index-1)/2;
    }
    static int left(int index){
        return 2*index+1;
    }
    static int right(int index){
        return 2*index+2;
    }
    static void add(int element, List<Integer> heap){
        heap.add(element);
        if((heap.size() == 1)) return;
        rearrangeUpwards(heap.size()-1, heap);
    }
    static void rearrangeUpwards(int elementIndex, List<Integer> heap){
        if(elementIndex == 0) return;
        int parentIndex = parent(elementIndex);
        if(heap.get(parentIndex) > heap.get(elementIndex)){
            swap(elementIndex,parentIndex,heap);
            rearrangeUpwards(parentIndex, heap);
        }
    }
    static int heapRemove(List<Integer> heap) throws Exception {
        if((heap.size() == 0)) throw new Exception("Empty heap");
        int temp =heap.get(0);
        int last =heap.remove(heap.size()-1);
        if(!heap.isEmpty()){
            heap.set(0,last);
            rearrangeDownwards(0,heap);
        }
        return temp;
    }
    static void rearrangeDownwards(int index, List<Integer> heap){
        int heapSize = heap.size();
        int min = index;
        int leftIndex = left(index);
        int rightIndex = right(index);
        int parent = heap.get(index);
        if(leftIndex< heapSize && heap.get(leftIndex)<parent)
            min = leftIndex;
        if(rightIndex< heapSize && heap.get(rightIndex)<parent)
            min= rightIndex;
        if(min != index){
            swap(min,index,heap);
            rearrangeDownwards(min,heap);
        }
    }

    static int[] heapSort(List<Integer> heap) throws Exception {
        int [] res = new int[heap.size()];
        int i =0;
        while(!heap.isEmpty()){
            res[i]= heapRemove(heap);
            i++;
        }
        return res;
    }
}
