class Solution {
    static final int MOD = 1_000_000_007;

    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] maxVal = new long[n][m];
        long[][] minVal = new long[n][m];
        maxVal[0][0] = grid[0][0];
        minVal[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            maxVal[i][0] = maxVal[i - 1][0] * grid[i][0];
            minVal[i][0] = minVal[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            maxVal[0][j] = maxVal[0][j - 1] * grid[0][j];
            minVal[0][j] = minVal[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long a = maxVal[i - 1][j] * grid[i][j];
                long b = minVal[i - 1][j] * grid[i][j];
                long c = maxVal[i][j - 1] * grid[i][j];
                long d = minVal[i][j - 1] * grid[i][j];

                maxVal[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minVal[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long answer = maxVal[n - 1][m - 1];
        if (answer < 0) {
            return -1;
        }

        return (int) (answer % MOD);
    }
}
