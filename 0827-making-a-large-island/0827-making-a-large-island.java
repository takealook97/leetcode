class Solution {
    static int N;
    static int[][] board;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static HashMap<Integer, Integer> map;
    static boolean[][] border;
    static int idx, answer;

    public int largestIsland(int[][] grid) {
        board = grid;
        N = board.length;
        border = new boolean[N][N];
        map = new HashMap<>();
        idx = 2;
        answer = 0;

        boolean hasZero = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    accumulate(i, j);
                } else {
                    hasZero = true;
                }
            }
        }

        if (!hasZero) return N * N;
        if (map.size() == 0) return 1;

        for (int size : map.values()) {
            answer = Math.max(answer, size);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (border[i][j]) {
                    find(i, j);
                }
            }
        }

        return answer;
    }

    static void accumulate(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        int sum = 0;
        int id = idx++;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0], curX = now[1];

            if (board[curY][curX] != 1) continue;
            board[curY][curX] = id;
            sum++;

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                if (isInRange(nextY, nextX)) {
                    if (board[nextY][nextX] == 1) {
                        queue.add(new int[]{nextY, nextX});
                    } else if (board[nextY][nextX] == 0) {
                        border[nextY][nextX] = true;
                    }
                }
            }
        }

        map.put(id, sum);
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    static void find(int y, int x) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (isInRange(nextY, nextX) && board[nextY][nextX] > 1) {
                set.add(board[nextY][nextX]);
            }
        }

        int sum = 1;
        for (int id : set) {
            sum += map.get(id);
        }

        answer = Math.max(answer, sum);
    }
}
