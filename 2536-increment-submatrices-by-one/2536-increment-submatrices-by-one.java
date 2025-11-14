class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] board = new int[n][n];
        for (int[] query : queries) {
            board[query[0]][query[1]]++;
            if (query[2] + 1 < n) {
                board[query[2] + 1][query[1]]--;
            }

            if (query[3] + 1 < n) {
                board[query[0]][query[3] + 1]--;
            }

            if (query[2] + 1 < n && query[3] + 1 < n) {
                board[query[2] + 1][query[3] + 1]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = i > 0 ? board[i - 1][j] : 0;
                int b = j > 0 ? board[i][j - 1] : 0;
                int c = i > 0 && j > 0 ? board[i - 1][j - 1] : 0;
                board[i][j] += (a + b - c);
            }
        }

        return board;
    }
}
