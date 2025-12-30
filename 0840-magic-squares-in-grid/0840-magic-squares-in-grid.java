class Solution {
    static int N, M;
    static int[][] grid;

    public int numMagicSquaresInside(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        this.grid = grid;
        int answer = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (isPossible(i, j)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    static boolean isPossible(int y, int x) {
        int base = grid[y][x] + grid[y][x + 1] + grid[y][x + 2];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grid[y + i][x + j];
            }
            if (sum != base) {
                return false;
            }

            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grid[y + j][x + i];
            }
            if (sum != base) {
                return false;
            }
        }

        if (base != grid[y][x] + grid[y + 1][x + 1] + grid[y + 2][x + 2]) {
            return false;
        }
        if (base != grid[y + 2][x] + grid[y + 1][x + 1] + grid[y][x + 2]) {
            return false;
        }

        return true;
    }
}
