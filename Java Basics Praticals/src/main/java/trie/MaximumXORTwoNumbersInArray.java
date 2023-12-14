package trie;

import java.util.HashMap;
import java.util.Map;

public class MaximumXORTwoNumbersInArray {
    class TrieNode{
        Map<Integer,TrieNode> child;
        TrieNode(){
            this.child = new HashMap<>();
        }
    }
    private  TrieNode root;
    MaximumXORTwoNumbersInArray(){
        this.root = new TrieNode();
    }
     void insert(int num){
        TrieNode node = root;
        for(int i =31;i>=0;i--){
            int bit = (num>>i)&1;//num>>i will bring the ith bit to 0th position, and when we & 0th bit with 1 we will only get 0th bit rest will be set to 0
            if(!node.child.containsKey(bit)){
                node = node.child.computeIfAbsent(bit,b->new TrieNode());
            }else
                node = node.child.get(bit);
        }
    }

     int getMax(int a2){
        TrieNode node = root;
        int max = 0;
        for(int i=31;i>=0;i--){
            if(node != null) {
                int bit = (a2>>i)&1;
                if(node.child.containsKey(1-bit)){
                    max = max | (1<<i) ;//since in xor if 2 bit( a1(trieNode bit)^ a2(ith bit)) are different, result will be 1, so we are flipping max's ith bit to 1
                    node = node.child.get(1-bit);
                }else {
                    node = node.child.get(bit);
                }
            }
        }
        return max;
    }
     int maxXor(int[] arr1,int[] arr2){
        int max = Integer.MIN_VALUE;
        for(int a1: arr1){
            insert(a1);
        }
        for (int a2: arr2){
            max = Math.max(max,getMax(a2));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {6,8};
        int[] arr2 = {7,8,2};
        MaximumXORTwoNumbersInArray maximumXORTwoNumbersInArray = new MaximumXORTwoNumbersInArray();
        System.out.println("Max xor is : "+maximumXORTwoNumbersInArray.maxXor(arr1,arr2));
    }
}
