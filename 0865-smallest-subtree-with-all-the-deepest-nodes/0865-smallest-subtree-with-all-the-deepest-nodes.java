/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    static class Info {
        TreeNode node;
        int depth;

        Info(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(null, 0);
        }

        Info left = dfs(root.left);
        Info right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Info(root, left.depth + 1);
        }

        if (left.depth > right.depth) {
            return new Info(left.node, left.depth + 1);
        }

        return new Info(right.node, right.depth + 1);
    }
}
