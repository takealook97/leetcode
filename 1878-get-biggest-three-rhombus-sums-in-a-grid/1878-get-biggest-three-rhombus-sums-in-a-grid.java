class Solution {
    static int N, M;
    static int[][] grid;
    static TreeSet<Integer> set;

    public int[] getBiggestThree(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        M = grid[0].length;
        set = new TreeSet<>(Collections.reverseOrder());

        int limit = Math.max(N, M) / 2 + 1;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int d = 0; d <= limit; d++) {
                    if (isPossible(y, x, d)) {
                        set.add(getSum(y, x, d));
                        if (set.size() > 3) {
                            set.pollLast();
                        }
                    }
                }
            }
        }

        int size = set.size();
        int[] answer = new int[size];

        int i = 0;
        for (int v : set) {
            answer[i++] = v;
        }

        return answer;
    }

    static boolean isPossible(int y, int x, int d) {
        return y + 2 * d < N && x - d >= 0 && x + d < M;
    }

    static int getSum(int y, int x, int d) {
        if (d == 0) {
            return grid[y][x];
        }

        int sum = 0;
        int topY = y;
        int topX = x;
        int rightY = y + d;
        int rightX = x + d;
        int bottomY = y + 2 * d;
        int bottomX = x;
        int leftY = y + d;
        int leftX = x - d;

        for (int i = 0; i < d; i++) {
            sum += grid[topY + i][topX + i];
        }

        for (int i = 0; i < d; i++) {
            sum += grid[rightY + i][rightX - i];
        }

        for (int i = 0; i < d; i++) {
            sum += grid[bottomY - i][bottomX - i];
        }

        for (int i = 0; i < d; i++) {
            sum += grid[leftY - i][leftX + i];
        }

        return sum;
    }
}
