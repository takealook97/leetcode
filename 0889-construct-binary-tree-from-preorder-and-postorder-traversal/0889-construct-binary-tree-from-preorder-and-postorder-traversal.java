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
    static int[] preorder, postorder;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        
        return find(new int[]{0}, 0, postorder.length - 1);
    }

    static TreeNode find(int[] preIndex, int postStart, int postEnd) {
        if (postStart > postEnd || preIndex[0] >= preorder.length) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex[0]++]);
        
        if (postStart == postEnd) {
            return root;
        }
        
        int leftRootVal = preorder[preIndex[0]];
        int leftSubtreeEnd = postStart;
        
        while (postorder[leftSubtreeEnd] != leftRootVal) {
            leftSubtreeEnd++;
        }

        root.left = find(preIndex, postStart, leftSubtreeEnd);
        root.right = find(preIndex, leftSubtreeEnd + 1, postEnd - 1);

        return root;
    }
}
