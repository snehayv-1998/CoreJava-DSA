package tree;

import java.util.HashMap;

public class PreInorderBst {
    /*
    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     */
    public static void main(String[] args) {
        System.out.println("PreInorderBst " + buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int p = 0;

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, inorder.length - 1);
    }

    static TreeNode build(int[] preorder, HashMap<Integer, Integer> map, int l, int r) {
        if (l > r) return null;
        int current = preorder[p];
        p++;
        TreeNode node = new TreeNode(current);
        //if(l==r) return node;
        node.left = build(preorder, map, l, map.get(current) - 1);
        node.right = build(preorder, map, map.get(current) + 1, r);
        return node;
    }
}