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
    static int[] sumArr;

    public TreeNode replaceValueInTree(TreeNode root) {
        sumArr = new int[100001];

        setSum(root, 0);
        alter(root, 0);
        root.val = 0;

        return root;
    }

    static void setSum(TreeNode node, int depth) {
        sumArr[depth] += node.val;

        if (node.left != null) {
            setSum(node.left, depth + 1);
        }

        if (node.right != null) {
            setSum(node.right, depth + 1);
        }
    }

    static void alter(TreeNode node, int depth) {
        int sum = 0;
        if (node.left != null) {
            sum += node.left.val;
        }

        if (node.right != null) {
            sum += node.right.val;
        }

        int result = sumArr[depth + 1] - sum;

        if(result >= 0) {
            if (node.left != null) {
                node.left.val = result;
            }

            if (node.right != null) {
                node.right.val = result;
            }
        }

        if (node.left != null) {
            alter(node.left, depth + 1);
        }

        if (node.right != null) {
            alter(node.right, depth + 1);
        }
    }
}
