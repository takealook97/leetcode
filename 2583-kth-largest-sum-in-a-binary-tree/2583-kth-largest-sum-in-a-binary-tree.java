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
    static long[] sum;
    static long answer = -1;

    static final int MAX = 100000;

    public long kthLargestLevelSum(TreeNode root, int k) {
        sum = new long[MAX];
        search(root, 0);
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(long i : sum) {
            if(i == 0) break;
            pq.add(i);
        }

        if(pq.size() < k) {
            return -1;
        }

        while(k-- > 0) {
            answer = pq.poll();
        }

        return answer;
    }

    static void search(TreeNode now, int depth) {
        sum[depth] += now.val;

        if (now.left != null) {
            search(now.left, depth + 1);
        }

        if (now.right != null) {
            search(now.right, depth + 1);
        }
    }
}
