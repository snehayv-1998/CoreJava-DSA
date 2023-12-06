package tree;

import java.util.Scanner;

public class BinaryTree {
    private Node root;
    private class Node{
        int val;
        int height;
        Node left;
        Node right;
        Node (int val){
            this.val = val;
        }
    }
     void insert(int value){
        root= insertRecursive(root,value);
     }
    private Node insertRecursive(int val,Node node){
        if(node == null){
            Node node1 = new Node(val);
            return node1;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert left : ");
        boolean left = scanner.nextBoolean();
        if(left){
            root.left= insertRecursive(val, node.left);
        }else
            root.right= insertRecursive(val,node.right);
        return root;
    }
    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (root.left == null) {
            root.left = insertRecursive(root.left, data);
        } else {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }
    void display(){
        System.out.println("DFS: ");
        System.out.println("Pre order:");
        preOrder(root);
        System.out.println("\nIn order :");
        inOrderTraversalRecursive(root);
        System.out.println("\nPost order:");
        postOrder(root);

        System.out.println("BFS");
    }

    private void inOrderTraversalRecursive(Node root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.val + " ");
            inOrderTraversalRecursive(root.right);
        }
    }
    private void postOrder(Node node){
        if(node== null)return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val +" ");
    }

    private void preOrder(Node node){
        if(node== null)return;
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
