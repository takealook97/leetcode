class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int N = mat.length;
        int M = mat[0].length;
        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = mat[i - 1][j - 1] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        int answer = 0;
        for (int k = 1; k <= Math.min(N, M); k++) {
            boolean ok = false;
            for (int i = k; i <= N; i++) {
                for (int j = k; j <= M; j++) {
                    int sum = arr[i][j]
                            - arr[i - k][j]
                            - arr[i][j - k]
                            + arr[i - k][j - k];
                    if (sum <= threshold) {
                        ok = true;
                        break;
                    }
                }
                if (ok) break;
            }
            if (ok) answer = k;
            else break;
        }

        return answer;
    }
}
