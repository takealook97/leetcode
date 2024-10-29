class Solution {
    static int N, M;
    static int[] dy = {-1, 0, 1}, dx = {1, 1, 1};

    public int maxMoves(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        int answer = 1;

        int[][] dp = new int[N][M];
        for(int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        int nextY, nextX;
        for(int nowX = 0; nowX < M; nowX++) {
            for(int nowY = 0; nowY < N; nowY++) {
                if(dp[nowY][nowX] <= 0) {
                    continue;
                }
                
                for(int i = 0; i < 3; i++) {
                    nextY = nowY + dy[i];
                    nextX = nowX + dx[i];
                    if(isInRange(nextY, nextX) && grid[nowY][nowX] < grid[nextY][nextX]) {
                        dp[nextY][nextX] = Math.max(dp[nextY][nextX], dp[nowY][nowX] + 1);
                        answer = Math.max(answer, dp[nextY][nextX]);
                    }
                }
            }
        }

        return answer - 1;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
