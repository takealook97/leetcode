class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] x = new int[N + 1][M + 1];
        int[][] y = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char c = grid[i - 1][j - 1];
                x[i][j] = (c == 'X' ? 1 : 0) + x[i - 1][j] + x[i][j - 1] - x[i - 1][j - 1];
                y[i][j] = (c == 'Y' ? 1 : 0) + y[i - 1][j] + y[i][j - 1] - y[i - 1][j - 1];
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (x[i][j] == y[i][j] && x[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
