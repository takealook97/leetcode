class Solution {
    static final long LIMIT = Long.MIN_VALUE / 2;
    static final int NONE = 0, L = 1, S = 2;

    public long maximumProfit(int[] prices, int k) {
        int len = prices.length;
        long[][] dp = new long[k + 1][3];

        for (int i = 0; i <= k; i++) {
            dp[i][NONE] = LIMIT;
            dp[i][L] = LIMIT;
            dp[i][S] = LIMIT;
        }
        dp[0][NONE] = 0;

        for (int price : prices) {
            for (int i = k; i >= 0; i--) {
                if (dp[i][NONE] != LIMIT) {
                    dp[i][L] = Math.max(dp[i][L], dp[i][NONE] - price);
                    dp[i][S] = Math.max(dp[i][S], dp[i][NONE] + price);
                }
                if (i + 1 <= k) {
                    if (dp[i][L] != LIMIT) {
                        dp[i + 1][NONE] = Math.max(dp[i + 1][NONE], dp[i][L] + price);
                    }
                    if (dp[i][S] != LIMIT) {
                        dp[i + 1][NONE] = Math.max(dp[i + 1][NONE], dp[i][S] - price);
                    }
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= k; i++) {
            answer = Math.max(answer, dp[i][NONE]);
        }
        
        return answer;
    }
}
