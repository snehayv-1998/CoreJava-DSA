package DP.dpOnTree;

public class DiameterOfTree {
    static int diameter = Integer.MIN_VALUE;
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
        System.out.println(calculateHeight(new TreeNode(1,new TreeNode(2),new TreeNode(3))));
    }
     // Function to calculate
        // the height of a subtree
    static int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the
        // height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Calculate the diameter at the current
        // node and update the global variable
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height
        // of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
