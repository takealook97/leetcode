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
    static List<List<Integer>> list;
    static int answer;

    public int minimumOperations(TreeNode root) {
        answer = 0;
        list = new ArrayList<>();

        find(root, 0);

        for (List<Integer> row : list) {
            count(row);
        }

        return answer;
    }

    static void find(TreeNode now, int depth) {
        if (list.size() < depth + 1) {
            list.add(new ArrayList<>());
        }

        list.get(depth).add(now.val);

        if (now.left != null) {
            find(now.left, depth + 1);
        }

        if (now.right != null) {
            find(now.right, depth + 1);
        }
    }

    static void count(List<Integer> row) {
        int n = row.size();
        boolean[] visited = new boolean[n];

        List<Integer> sortedRow = new ArrayList<>(row);
        Collections.sort(sortedRow);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sortedRow.get(i), i);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(row.get(i)) == i) {
                continue;
            }

            int size = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(row.get(j));
                size++;
            }

            if (size > 1) {
                answer += size - 1;
            }
        }
    }
}
