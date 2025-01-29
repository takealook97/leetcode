class Solution {
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1 ,1};
    static Queue<int[]> queue;

    public void solve(char[][] board) {
        N = board.length;
        M = board[0].length;
        this.board = board;
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i][0] && this.board[i][0] == 'O') {
                check(i, 0, true);
            }

            if (!visited[i][M - 1] && this.board[i][M - 1] == 'O') {
                check(i, M - 1, true);
            }
        }

        for (int i = 0; i < M; i++) {
            if (!visited[0][i] && this.board[0][i] == 'O') {
                check(0, i, true);
            }

            if (!visited[N - 1][i] && this.board[N - 1][i] == 'O') {
                check(N - 1, i, true);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (this.board[i][j] == 'O' && !visited[i][j]) {
                    check(i, j, false);
                }
            }
        }

        System.out.println(Arrays.deepToString(this.board));
    }

    static void check(int y, int x, boolean isBoarder) {
        queue.clear();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if (!isBoarder) {
                board[now[0]][now[1]] = 'X';
            }

            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (isInRange(nextY, nextX) && !visited[nextY][nextX] && board[nextY][nextX] == 'O') {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
