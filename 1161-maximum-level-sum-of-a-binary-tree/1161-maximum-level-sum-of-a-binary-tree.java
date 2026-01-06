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
    public int maxLevelSum(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        list.add(root);

        int sum;
        while (!list.isEmpty()) {
            sum = 0;
            for (TreeNode node : list) {
                sum += node.val;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }

            sumList.add(sum);
            list.clear();
            list.addAll(temp);
            temp.clear();
        }

        int depth = 1, max = Integer.MIN_VALUE, answer = 1;
        for (int num : sumList) {
            if (num > max) {
                max = num;
                answer = depth;
            }
            depth++;
        }
        
        return answer;
    }
}
