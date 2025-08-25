class Solution {
    static int N, M, len, idx;
    static int[][] board;
    static int[] answer;

    public int[] findDiagonalOrder(int[][] mat) {
        this.board = mat;
        N = board.length;
        M = board[0].length;
        len = N * M;
        answer = new int[len];
        idx = 0;

        find(0, 0, true);

        return answer;
    }

    static void find(int y, int x, boolean isUp) {
        if (!isInRange(y, x)) {
            return;
        }

        while (isInRange(y, x)) {
            answer[idx++] = board[y][x];
            
            if (isUp) {
                y--;
                x++;
            } else {
                y++;
                x--;
            }
        }

        if (isUp) {
            if (0 <= x && x < M) {
                y++;
            } else {
                x--;
                y += 2;
            }
        } else {
            if (0 <= y && y < N) {
                x++;
            } else {
                y--;
                x += 2;
            }
        }

        find(y, x, !isUp);
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}