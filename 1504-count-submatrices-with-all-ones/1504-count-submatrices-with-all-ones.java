class Solution {
    public int numSubmat(int[][] mat) {
        int N = mat.length, M = mat[0].length;
        int answer = 0;
        int[][] dp = new int[N][M];
        int cur;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (x == 0) {
                    dp[y][x] = mat[y][x];
                } else {
                    if (mat[y][x] == 0) {
                        dp[y][x] = 0;
                    } else {
                        dp[y][x] = dp[y][x - 1] + 1;
                    }
                }
                
                cur = dp[y][x];
                for (int i = y; i >= 0; i--) {
                    cur = Math.min(cur, dp[i][x]);
                    if (cur == 0) {
                        break;
                    }

                    answer += cur;
                }
            }
        }

        return answer;
    }
}