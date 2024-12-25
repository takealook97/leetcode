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
    static TreeMap<Integer, Integer> map;

    public List<Integer> largestValues(TreeNode root) {
        map = new TreeMap<>();
        find(root, 0);
        return new ArrayList<>(map.values());
    }

    static void find(TreeNode now, int depth) {
        if (map.getOrDefault(depth, -1) == -1) {
            if (now == null) return;
            map.put(depth, now.val);
        } else {
            map.put(depth, Math.max(map.get(depth), now.val));
        }

        if (now.left != null) {
            find(now.left, depth + 1);
        }

        if (now.right != null) {
            find (now.right, depth + 1);
        }
    }
}
