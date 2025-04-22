class Solution {
    static final int MOD = 1_000_000_007, LIMIT = 14;

    public int idealArrays(int n, int maxValue) {
        long[][] arr = new long[n + 1][LIMIT + 1];
        for (int i = 0; i <= n; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= Math.min(i, LIMIT); j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % MOD;
            }
        }

        int[][] dp = new int[LIMIT + 1][maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }

        for (int len = 2; len <= LIMIT; len++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int j = 2 * i; j <= maxValue; j += i) {
                    dp[len][j] = (dp[len][j] + dp[len - 1][i]) % MOD;
                }
            }
        }

        long answer = 0;
        for (int len = 1; len <= LIMIT; len++) {
            long count = 0;
            for (int i = 1; i <= maxValue; i++) {
                count = (count + dp[len][i]) % MOD;
            }
            answer = (answer + count * arr[n - 1][len - 1] % MOD) % MOD;
        }

        return (int) answer;
    }
}
