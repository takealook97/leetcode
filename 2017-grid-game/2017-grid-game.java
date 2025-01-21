class Solution {
    static int N, M;
    static long[] topSum, bottomSum;

    public long gridGame(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        topSum = new long[M];
        bottomSum = new long[M];

        topSum[0] = grid[0][0];
        bottomSum[0] = grid[1][0];
        for (int i = 1; i < M; i++) {
            topSum[i] = topSum[i - 1] + grid[0][i];
            bottomSum[i] = bottomSum[i - 1] + grid[1][i];
        }

        long answer = Long.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            long topPoints = i < M - 1 ? topSum[M - 1] - topSum[i] : 0;
            long bottomPoints = i > 0 ? bottomSum[i - 1] : 0;
            answer = Math.min(answer, Math.max(topPoints, bottomPoints));
        }

        return answer;
    }
}
