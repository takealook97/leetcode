class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];
            int skip = questions[i][1];
            int next = i + skip + 1;
            long solve = point;
            if (next < n) {
                solve += dp[next];
            }

            long skipIt = dp[i + 1];

            dp[i] = Math.max(solve, skipIt);
        }

        return dp[0];
    }
}
