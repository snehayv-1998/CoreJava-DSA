package DP.dpOnTree;

public class MaxPathSum {
    static int maxSum = Integer.MIN_VALUE;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;}}
    public static void main(String[] args) {
        System.out.println(maxPathSum(new TreeNode(1,new TreeNode(2),new TreeNode(3))));
        maxSum=Integer.MIN_VALUE;
        System.out.println(maxPathSum(new TreeNode(2,new TreeNode(-1),null)));
    }
    static public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

   static int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
       // Recursively calculate the maximum path sum of left and right subtrees
       int leftMax = Math.max(0, solve(root.left)); // Ignore negative paths
       int rightMax = Math.max(0, solve(root.right)); // Ignore negative paths

       // Update the maximum sum encountered so far
       maxSum = Math.max(maxSum, leftMax + rightMax + root.val);

       // Return the maximum path sum that includes the current node and one of its subtrees
       return Math.max(leftMax, rightMax) + root.val;
    }
}
