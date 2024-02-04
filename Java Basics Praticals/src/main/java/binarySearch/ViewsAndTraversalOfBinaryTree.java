package binarySearch;

import tree.TreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ViewsAndTraversalOfBinaryTree {
    public static class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
       TreeNode node1 = new TreeNode(20,new TreeNode(15,new TreeNode(14),new TreeNode(16)), new TreeNode(27));

       TreeNode root = new TreeNode(10, new TreeNode(2,new TreeNode(1), null),node1);
       System.out.println("left view:"+ leftView(root));
       System.out.println("right view:"+rightView(root));
        System.out.println("boundary view :"+boundaryView(root));
    }

    private static List<Integer> boundaryView(TreeNode root) {
        return null;
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,0,res);
        return res;
    }
    static void helper(TreeNode node, int level, List<Integer> res){
        if(node == null) return;
        if(level== res.size()){
            res.add(node.val);
        }
        helper(node.left,level+1,res);
        helper(node.right,level+1,res);
    }

    private static List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helperRightView(root,0,res);
        return res;
    }

    private static void helperRightView(TreeNode node, int level, List<Integer> res) {
        if(node == null) return;
        if(level == res.size()){
            res.add(node.val);
        }
        helperRightView(node.right,level+1,res);
        helperRightView(node.left,level+1,res);
    }
/*
    public static List<Integer> boundaryView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0 ;i<size;i++){
                TreeNode node = queue.poll();
                if(i==0 || i==size-1 || node.left== null || node.right==null ){
                    res.add(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
*/

}
