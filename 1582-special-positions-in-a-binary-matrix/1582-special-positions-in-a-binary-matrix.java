class Solution {
    static int n, m;
    static int[][] mat;

    public int numSpecial(int[][] mat) {
        this.mat = mat;
        n = mat.length;
        m = mat[0].length;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && check(i, j)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    static boolean check(int y, int x) {
        for (int i = 0; i < n; i++) {
            if (i != y && mat[i][x] == 1) {
                return false;
            }
        }
        for (int i = 0; i < m; i++) {
            if (i != x && mat[y][i] == 1) {
                return false;
            }
        }
        return true;
    }
}