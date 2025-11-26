class Solution {
    static final int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m + 1][n + 1][k];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j][grid[0][0] % k] = 1;
                    continue;
                }

                int val = grid[i - 1][j - 1] % k;
                for (int x = 0; x < k; x++) {
                    int prev = (x - val + k) % k;
                    dp[i][j][x] = (dp[i - 1][j][prev] + dp[i][j - 1][prev]) % MOD;
                }
            }
        }

        return (int) dp[m][n][0];
    }
}
