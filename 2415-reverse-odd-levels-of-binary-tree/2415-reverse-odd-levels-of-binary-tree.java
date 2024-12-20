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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean isOddLevel = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode[] nodesAtLevel = new TreeNode[size];

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                nodesAtLevel[i] = current;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            if (isOddLevel) {
                for (int i = 0; i < size / 2; i++) {
                    int temp = nodesAtLevel[i].val;
                    nodesAtLevel[i].val = nodesAtLevel[size - 1 - i].val;
                    nodesAtLevel[size - 1 - i].val = temp;
                }
            }

            isOddLevel = !isOddLevel;
        }

        return root;
    }
}
