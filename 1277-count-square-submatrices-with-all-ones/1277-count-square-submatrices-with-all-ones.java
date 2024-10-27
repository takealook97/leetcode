class Solution {
    static int N, M;

    public int countSquares(int[][] matrix) {
        N = matrix.length;
        M = matrix[0].length;

        int answer = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                for(int gap = 0; gap <= N; gap++) {
                    if(isInRange(y + gap, x + gap) && isSquare(matrix, y, x, y + gap, x + gap)) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }

    static boolean isSquare(int[][] matrix, int fromY, int fromX, int toY, int toX) {
        for(int y = fromY; y <= toY; y++) {
            for(int x = fromX; x <= toX; x++) {
                if(matrix[y][x] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}