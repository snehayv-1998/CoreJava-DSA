package tree;

import java.util.*;
import java.util.stream.Collectors;
/*
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 */

public class VerticalOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static  class Node{
        int r;
        int c;
        TreeNode v;
        Node(int r,int c,TreeNode v){
            this.c=c;
            this.r=r;
            this.v=v;
        }
    }
    static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> queue = new ArrayDeque<>();
        Map<Integer,ArrayList<Node>> map = new HashMap<>();
        queue.offer(new Node(0,0,root));
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node removed = queue.poll();
            TreeNode node = removed.v;
            int col = removed.c;
            int row = removed.r;
            if(!map.containsKey(col)){
                map.put(col,new ArrayList<>());
            }
            map.get(col).add(removed);
            min = Math.min(min,col);
            max = Math.max(max,col);
            if(node.left!=null)
                queue.offer(new Node(row,col-1,node.left));
            if(node.right!=null)
                queue.offer(new Node(row,col+1,node.right));
        }

        for(int i=min;i<=max;i++){
            List<Node> node = map.get(i);
            ans.add(node.stream().sorted(Comparator.comparingInt(n->n.r)).map(n->n.v.val).collect(Collectors.toList()));
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(4), new TreeNode(6));
        TreeNode right = new TreeNode(3,new TreeNode(5),new TreeNode(7));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println("***********************Result: "+verticalTraversal(root));

    }
}
