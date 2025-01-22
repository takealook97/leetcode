class Solution {
    static int N, M;
    static int[][] isWater, board;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    static final int FALSE = 0, TRUE = 1, Y = 0, X = 1;

    public int[][] highestPeak(int[][] isWater) {
        N = isWater.length;
        M = isWater[0].length;
        this.isWater = isWater;
        board = new int[N][M];

        Set<int[]> now = new HashSet<>();
        Set<int[]> next = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isWater[i][j] == TRUE) {
                    now.add(new int[]{i, j});
                }
            }
        }

        while (!now.isEmpty()) {
            for (int[] point : now) {
                for (int i = 0; i < 4; i++) {
                    int nextY = point[Y] + dy[i];
                    int nextX = point[X] + dx[i];
                    if (isPossible(nextY, nextX)) {
                        board[nextY][nextX] = board[point[Y]][point[X]] + 1;
                        next.add(new int[]{nextY, nextX});
                    }
                }
            }

            now.clear();
            now.addAll(next);
            next.clear();
        }

        return board;
    }

    static boolean isPossible(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M && 
            isWater[y][x] == FALSE && board[y][x] == 0;
    }
}
