class Solution {
    static int N, M;
    static int[][] board;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int answer;

    static final int Y = 0, X = 1, EMPTY = 0, CHECK = 1, GUARD = 2, WALL = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        N = m;
        M = n;
        board = new int[N][M];

        // set
        for (int[] guard : guards) {
            board[guard[Y]][guard[X]] = GUARD;
        }
        for (int[] wall : walls) {
            board[wall[Y]][wall[X]] = WALL;
        }

        // check
        for (int[] guard : guards) {
            update(guard[Y], guard[X]);
        }

        // count
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == EMPTY) {
                    answer++;
                }
            }
        }

        return answer;
    }
    
    static void update(int startY, int startX) {
        for (int i = 0; i < 4; i++) {
            int y = startY;
            int x = startX;
            while (true) {
                y += dy[i];
                x += dx[i];
                if (isPossible(y, x)) {
                    board[y][x] = CHECK;
                    continue;
                }
                break;
            }
        }
    }
    
    static boolean isPossible(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M && board[y][x] <= 1;
    }
}
