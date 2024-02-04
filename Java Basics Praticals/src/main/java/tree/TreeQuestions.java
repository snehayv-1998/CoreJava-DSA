package tree;

import java.util.*;

public class TreeQuestions {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(20,new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3,new TreeNode(9),node1);
        System.out.println("***********************Result: "+zigzagLevelOrder(root));

    }
    public static class TreeNode {
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

    class Solution {
        /*
        Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[9,20],[15,7]]
        Example 2:
        Input: root = [1]
        Output: [[1]]
        Example 3:
        Input: root = []
        Output: []
     */

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>>  result = new ArrayList<>();
            if(root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> currentValue = new ArrayList<>();
                int size = queue.size();
                for(int i=0;i<size;i++){
                    TreeNode node = queue.poll();
                    currentValue.add(node.val);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
                result.add(currentValue);
            }
            return result;
        }

    }
   /**/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res= new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            double avgLevel = 0.0;
            int size = queue.size();
            for(int i=0; i<size;i++){
                TreeNode currentNode = queue.poll();
                avgLevel += currentNode.val;
                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            avgLevel = avgLevel/size;
            res.add(avgLevel);
        }
        return res;
    }
    /*
    find the level order successor for a node
     */
    public TreeNode levelsOrderSuccessor(TreeNode root) {
        if(root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null)
                    queue.offer(currentNode.left);
            if(currentNode.right != null)
                    queue.offer(currentNode.right);
            if(currentNode.val == root.val)
                break;
        }
        return queue.peek();
    }
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>  result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> currentValue = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                currentValue.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(0,currentValue);
        }
        return result;
    }
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        Deque<TreeNode> queue =  new LinkedList<TreeNode>();
        queue.add(root);
        boolean isReverse=  false;
        while(!queue.isEmpty()){
            List<Integer> currentValue= new ArrayList<>();
            int size = queue.size();
            for(int i =0 ;i<size;i++){
                if(isReverse){
                    TreeNode node = queue.pollLast();
                    currentValue.add(node.val);
                    if(node.right != null)
                        queue.addFirst(node.right);
                    if(node.left != null)
                        queue.addFirst(node.left);
                }else{
                    TreeNode node = queue.pollFirst();
                    currentValue.add(node.val);
                    if(node.left != null)
                        queue.addLast(node.left);
                    if(node.right != null)
                        queue.addLast(node.right);
                }
            }
            isReverse = !isReverse;
            res.add(currentValue);
        }
        return res;
    }
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solutions/
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if(root == null) return null;
        Node leftNode = root;
        while(leftNode.left != null){
            Node currentNode = leftNode;
            while(currentNode != null){
                currentNode.left.next =  currentNode.right;
                if( currentNode.next  != null)
                    currentNode.right.next = currentNode.next.left;
                currentNode = currentNode.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }
  //  https://leetcode.com/problems/binary-tree-right-side-view/
  public List<Integer> rightSideView(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      if(root == null) return res;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
          int size =  queue.size();
          for(int i = 0; i<size; i++){
              TreeNode currentNode = queue.poll();
              if(i == size-1)
                  res.add(currentNode.val);
              if(currentNode.left != null)
                  queue.offer(currentNode.left);
              if(currentNode.right != null)
                  queue.offer(currentNode.right);
          }
      }
      return res;
  }
    public List<Integer> rightSideViewDepth1stSearch(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,0,res);
        return res;
    }
    void helper(TreeNode node, int level,  List<Integer> res ){
        if(node == null) return;
        if(level== res.size()){
            res.add(node.val);
        }
        helper(node.right,level+1,res);
        helper(node.left,level+1,res);
    }
  //cousins
    //https://leetcode.com/problems/symmetric-tree/
}
