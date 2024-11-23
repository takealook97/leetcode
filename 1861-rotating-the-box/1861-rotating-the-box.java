class Solution {
    static final char STONE = '#', OBSTACLE = '*', EMPTY = '.';

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] answer = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == STONE) {
                    int nextX = j;
                    while (true) {
                        if (nextX + 1 < n && box[i][nextX + 1] == EMPTY) {
                            nextX++;
                        } else {
                            break;
                        }
                    }
                    box[i][j] = EMPTY;
                    box[i][nextX] = STONE;
                }
            }

            for (int j = 0; j < n; j++) {
                answer[j][m - i - 1] = box[i][j];
            }
        }

        return answer;
    }
}
