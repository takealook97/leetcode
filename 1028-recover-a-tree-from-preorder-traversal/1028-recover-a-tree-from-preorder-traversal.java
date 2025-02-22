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
import java.util.*;

class Solution {
    static final char DASH = '-';

    public TreeNode recoverFromPreorder(String traversal) {
        int len = traversal.length();
        Deque<TreeNode> stack = new ArrayDeque<>();
        int index = 0;

        while (index < len) {
            int depth = 0;
            while (index < len && traversal.charAt(index) == DASH) {
                depth++;
                index++;
            }

            int value = 0;
            while (index < len && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(value);
            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
