class Solution {
    static int n;
    static int[] answer;
    static boolean[] visited;

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        int len = 2 * n - 1;
        answer = new int[len];
        visited = new boolean[n + 1];
        find(0);
        return answer;
    }

    static boolean find(int idx) {
        if (idx == answer.length) {
            return true;
        }
        if (answer[idx] != 0) {
            return find(idx + 1);
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i]) {
                continue;
            }

            if (i == 1) {
                answer[idx] = 1;
                visited[1] = true;
                if (find(idx + 1)) {
                    return true;
                }
                answer[idx] = 0;
                visited[1] = false;
            } else {
                int nextIdx = idx + i;
                if (nextIdx < answer.length && answer[nextIdx] == 0) {
                    answer[idx] = answer[nextIdx] = i;
                    visited[i] = true;
                    if (find(idx + 1)) {
                        return true;
                    }
                    answer[idx] = answer[nextIdx] = 0;
                    visited[i] = false;
                }
            }
        }

        return false;
    }
}
