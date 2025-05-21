class Solution {
    static int N, M;
    static int[][] matrix;
    static Set<Integer> ySet, xSet;

    public void setZeroes(int[][] matrix) {
        N = matrix.length;
        M = matrix[0].length;
        this.matrix = matrix;
        ySet = new HashSet<>();
        xSet = new HashSet<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (matrix[y][x] == 0) {
                    ySet.add(y);
                    xSet.add(x);
                }
            }
        }

        for (int idx : ySet) {
            check(idx, true);
        }
        for (int idx : xSet) {
            check(idx, false);
        }
    }

    static void check(int idx, boolean isY) {
        if (isY) {
            for (int x = 0; x < M; x++) {
                matrix[idx][x] = 0;
            }
            return;
        }

        for (int y = 0; y < N; y++) {
            matrix[y][idx] = 0;
        }
    }
}
