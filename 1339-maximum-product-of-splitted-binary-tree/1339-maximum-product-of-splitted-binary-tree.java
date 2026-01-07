class Solution {
    static Map<Integer, int[]> map;

    static final int TO = 0, SUM = 1, SIZE = 2;
    static final int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        map = new HashMap<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> idxQueue = new ArrayDeque<>();

        int idx = 0;
        map.put(0, new int[SIZE]);
        map.get(0)[SUM] = root.val;

        queue.add(root);
        idxQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            int nowIdx = idxQueue.poll();

            if (now.left != null) {
                int leftIdx = ++idx;
                map.put(leftIdx, new int[SIZE]);
                map.get(leftIdx)[TO] = nowIdx;
                map.get(leftIdx)[SUM] = now.left.val;
                queue.add(now.left);
                idxQueue.add(leftIdx);
            }

            if (now.right != null) {
                int rightIdx = ++idx;
                map.put(rightIdx, new int[SIZE]);
                map.get(rightIdx)[TO] = nowIdx;
                map.get(rightIdx)[SUM] = now.right.val;
                queue.add(now.right);
                idxQueue.add(rightIdx);
            }
        }

        long total = 0;
        for (int[] v : map.values()) {
            total += v[SUM];
        }

        long max = 0;

        for (int i = idx; i > 0; i--) {
            int[] now = map.get(i);
            int parent = now[TO];
            map.get(parent)[SUM] += now[SUM];

            long part = now[SUM];
            long other = total - part;
            max = Math.max(max, part * other);
        }

        return (int) (max % MOD);
    }
}
