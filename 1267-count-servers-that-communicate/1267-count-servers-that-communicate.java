class Solution {
    public int countServers(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[] colCnt = new int[N];
        int[] rowCnt = new int[M];

        int duplicated = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    colCnt[i]++;
                    rowCnt[j]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1 && colCnt[i] > 1 && rowCnt[j] > 1) {
                    duplicated++;
                }
            }
        }

        int answer = 0;
        for (int i : colCnt) {
            if (i > 1) {
                answer += i;
            }
        }
        for (int i : rowCnt) {
            if (i > 1) {
                answer += i;
            }
        }

        return answer - duplicated;
    }
}
