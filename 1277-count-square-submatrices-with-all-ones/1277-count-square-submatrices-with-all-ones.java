class Solution {
    static int N, M;
    static int[][] board;

    public int countSquares(int[][] matrix) {
        N = matrix.length;
        M = matrix[0].length;
        this.board = matrix;
        int answer = 0;

        for (int fromY = 0; fromY < N; fromY++) {
            for (int fromX = 0; fromX < M; fromX++) {
                int gap = 0;
                while (fromY + gap < N && fromX + gap < M) {
                    int toY = fromY + gap;
                    int toX = fromX + gap;

                    if (isSquare(fromY, fromX, toY, toX)) {
                        answer++;
                        gap++;
                        continue;
                    }

                    break;
                }
            }
        }

        return answer;
    }

    static boolean isSquare(int fromY, int fromX, int toY, int toX) {
        for (int y = fromY; y <= toY; y++) {
            if (board[y][toX] == 0) {
                return false;
            }
        }

        for (int x = fromX; x <= toX; x++) {
            if (board[toY][x] == 0) {
                return false;
            }
        }

        return true;
    }
}