class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int nLen = nums.length;
        int qLen = queries.length;

        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        int[] sum = new int[nLen + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int cur = 0;
        int pos = 0;

        for (int i = 0; i < nLen; i++) {
            cur += sum[i];

            while (pos < qLen && queries[pos][0] == i) {
                pq.add(queries[pos][1]);
                pos++;
            }

            while (cur < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                cur++;
                sum[pq.poll() + 1]--;
            }

            if (cur < nums[i]) {
                return -1;
            }
        }

        return pq.size();
    }
}
