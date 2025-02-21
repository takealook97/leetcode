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

class FindElements {
    static TreeNode root;
    static Set<Integer> set;

    public FindElements(TreeNode root) {
        this.root = root;
        this.set = new HashSet<>();
        check(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    static void check(TreeNode node, int val) {
        if (node == null) return;

        node.val = val;
        set.add(val);

        check(node.left, 2 * val + 1);
        check(node.right, 2 * val + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */