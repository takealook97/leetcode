class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length(), m = strs.length;
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = strs[j].charAt(i);
            }
        }

        int[] dp = new int[n];
        int best = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                boolean check = true;
                for (int r = 0; r < m; r++) {
                    if (arr[j][r] > arr[i][r]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            best = Math.max(best, dp[i]);
        }

        return n - best;
    }
}
