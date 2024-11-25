class Solution {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    static class State {
        String state;
        int zeroPos, depth;

        State(String state, int zeroPos, int depth) {
            this.state = state;
            this.zeroPos = zeroPos;
            this.depth = depth;
        }
    }

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = toString(board);

        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(start, start.indexOf('0'), 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.state.equals(target)) {
                return cur.depth;
            }

            int y = cur.zeroPos / 3, x = cur.zeroPos % 3;

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i], nextX = x + dx[i];
                if (0 <= nextY && nextY < 2 && 0 <= nextX && nextX < 3) {
                    int nextZeroPos = nextY * 3 + nextX;
                    char[] chars = cur.state.toCharArray();
                    swap(chars, cur.zeroPos, nextZeroPos);

                    String nextState = new String(chars);
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(new State(nextState, nextZeroPos, cur.depth + 1));
                    }
                }
            }
        }

        return -1;
    }

    static String toString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
