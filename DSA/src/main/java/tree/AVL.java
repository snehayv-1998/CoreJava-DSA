package tree;

import java.util.Map;
import java.util.Scanner;

public class AVL {
    public static void main(String[] args) {
        System.out.println();
    }
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    private Node insertRecursive(int val,Node node){
        if(node == null){
            return new Node(val);
        }
        if(val<node.val){
            node.left= insertRecursive(val, node.left);
        }else
            node.right= insertRecursive(val,node.right);
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (!isBalanced(node)){
            
        }
        return node;
    }

    private boolean isBalanced(Node node) {
        return Math.abs(height(node.left)-height(node.right))<=1 && isBalanced(node.left) && isBalanced(node.right);
    }
    private int height(Node node) {
        if(node == null){
            return -1;
        }
        return Math.max(height(node.left),height(node.right))+1;
    }
}
