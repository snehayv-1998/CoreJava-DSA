package tree;

import java.util.*;
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
    static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        Queue<Map.Entry<TreeNode,Integer>> queue = new ArrayDeque<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root,0));
        Map<Integer,List<Integer>> res = new TreeMap<>();
        traverse(queue,res);
        for(Map.Entry<Integer,List<Integer>> entry:res.entrySet()){
            Collections.sort(entry.getValue());
            ans.add(entry.getValue());
        }
        return ans;
    }
    static void traverse(Queue<Map.Entry<TreeNode, Integer>> queue, Map<Integer, List<Integer>> res){
        while(!queue.isEmpty()){
            Map.Entry<TreeNode,Integer> root = queue.poll();
            TreeNode cur = root.getKey();
            int col = root.getValue();
            List<Integer> value = res.get(col) == null? new ArrayList<>(): res.get(col);
            value.add(cur.val);
            res.put(col,value);
            if(cur.left != null)
                queue.offer(new AbstractMap.SimpleEntry<>(cur.left,root.getValue()-1));
            if(cur.right != null)
                queue.offer(new AbstractMap.SimpleEntry<>(cur.right,root.getValue()+1));
        }
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1,new TreeNode(0), new TreeNode(2));
        TreeNode right = new TreeNode(4,new TreeNode(2),null);
        TreeNode root = new TreeNode(3,left,right);
        System.out.println("***********************Result: "+verticalTraversal(root));

    }
}
