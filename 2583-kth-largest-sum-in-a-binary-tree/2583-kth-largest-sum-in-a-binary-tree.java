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
        search(k, root, 0);
        Arrays.sort(sum);

        int cnt = 0;
        for(long i : sum) {
            cnt++;

            if(cnt == MAX - k + 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    static void search(int target, TreeNode now, int depth) {
        sum[depth] += now.val;

        if (now.left != null) {
            search(target, now.left, depth + 1);
        }

        if (now.right != null) {
            search(target, now.right, depth + 1);
        }
    }
}
