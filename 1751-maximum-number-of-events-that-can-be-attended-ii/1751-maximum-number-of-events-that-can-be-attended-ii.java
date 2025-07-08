class Solution {
    static int len;
    static int[][] events;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        this.events = events;
        len = events.length;

        int[][] dp = new int[len + 1][k + 1];

        for (int i = 1; i <= len; i++) {
            int[] event = events[i - 1];
            int lastIdx = lowerBound(i - 1, event[0]);

            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[lastIdx][j - 1] + event[2]);
            }
        }

        return dp[len][k];
    }

    static int lowerBound(int hi, int target) {
        int lo = 0, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (events[mid][1] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
