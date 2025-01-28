class Solution {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int answer;

    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        M = grid[0].length;
        visited = new boolean[N][M];
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    answer = Math.max(answer, find(i, j));
                }
            }
        }

        return answer;
    }


    static int find(int y, int x) {
        if (!isInRange(y, x) || grid[y][x] == 0 || visited[y][x]) {
            return 0;
        }

        visited[y][x] = true;
        int sum = grid[y][x];
        for (int i = 0; i < 4; i++) {
            sum += find(y + dy[i], x + dx[i]);
        }

        return sum;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
