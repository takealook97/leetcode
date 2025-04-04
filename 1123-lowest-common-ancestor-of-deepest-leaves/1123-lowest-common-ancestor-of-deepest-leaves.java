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
    static Map<Integer, List<TreeNode>> map;
    static int maxDepth;

    static class NodeInfo {
        int depth;
        TreeNode lca;

        NodeInfo(int depth, TreeNode lca) {
            this.depth = depth;
            this.lca = lca;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        map = new HashMap<>();
        maxDepth = 0;
        findDepth(root, 0);
        return dfs(root).lca;
    }

    static void findDepth(TreeNode node, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayList<>());
        }
        map.get(depth).add(node);

        if (node.left != null) {
            findDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            findDepth(node.right, depth + 1);
        }
    }

    static NodeInfo dfs(TreeNode node) {
        if (node == null) return new NodeInfo(-1, null);

        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);

        if (left.depth == right.depth) {
            return new NodeInfo(left.depth + 1, node);
        } else if (left.depth > right.depth) {
            return new NodeInfo(left.depth + 1, left.lca);
        } else {
            return new NodeInfo(right.depth + 1, right.lca);
        }
    }
}
