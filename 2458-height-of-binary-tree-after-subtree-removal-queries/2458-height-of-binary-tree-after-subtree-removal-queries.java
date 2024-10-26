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
    int[] start, end, segmentTree, nodeHeight;
    int[] euler, heightAtTime;
    int time = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = 100001;
        start = new int[n];
        end = new int[n];
        nodeHeight = new int[n];
        euler = new int[n];
        heightAtTime = new int[n];
        segmentTree = new int[4 * n];

        dfs(root, 0);
        buildSegmentTree(1, 0, time - 1);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int left = start[query];
            int right = end[query];
            result[i] = Math.max(
                querySegmentTree(1, 0, time - 1, 0, left - 1),
                querySegmentTree(1, 0, time - 1, right + 1, time - 1)
            );
        }

        return result;
    }

    private void dfs(TreeNode node, int height) {
        if (node == null) return;
        start[node.val] = time;
        euler[time] = node.val;
        heightAtTime[time++] = height;
        dfs(node.left, height + 1);
        dfs(node.right, height + 1);
        end[node.val] = time - 1;
    }

    private void buildSegmentTree(int node, int left, int right) {
        if (left == right) {
            segmentTree[node] = heightAtTime[left];
            return;
        }
        int mid = (left + right) / 2;
        buildSegmentTree(2 * node, left, mid);
        buildSegmentTree(2 * node + 1, mid + 1, right);
        segmentTree[node] = Math.max(segmentTree[2 * node], segmentTree[2 * node + 1]);
    }

    private int querySegmentTree(int node, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) return 0;
        if (queryLeft <= left && right <= queryRight) return segmentTree[node];
        int mid = (left + right) / 2;
        return Math.max(
            querySegmentTree(2 * node, left, mid, queryLeft, queryRight),
            querySegmentTree(2 * node + 1, mid + 1, right, queryLeft, queryRight)
        );
    }
}
