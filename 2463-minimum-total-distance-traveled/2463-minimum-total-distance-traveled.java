class Solution {
    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        Arrays.sort(factories, Comparator.comparingInt(a -> a[0]));

        int n = robots.size();
        int m = factories.length;
        
        long INF = (long) 1e18;
        long[][] dp = new long[n + 1][m + 1];
        for (long[] arr : dp) Arrays.fill(arr, INF);
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
            for (int i = 1; i <= n; i++) {
                long distance = 0;
                dp[i][j] = dp[i][j - 1];
                for (int k = 1; k <= factories[j - 1][1] && i - k >= 0; k++) {
                    distance += Math.abs(robots.get(i - k) - factories[j - 1][0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distance);
                }
            }
        }

        return dp[n][m];
    }
}
