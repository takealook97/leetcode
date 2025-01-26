class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            inDegree[favorite[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int next = favorite[current];
            depth[next] = Math.max(depth[next], depth[current] + 1);
            if (--inDegree[next] == 0) {
                queue.offer(next);
            }
        }

        boolean[] visited = new boolean[n];
        int maxCycle = 0, maxTwoCycleSum = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && inDegree[i] > 0) {
                int cycleSize = 0;
                int current = i;

                do {
                    visited[current] = true;
                    current = favorite[current];
                    cycleSize++;
                } while (current != i);

                if (cycleSize == 2) {
                    int depth1 = depth[i];
                    int depth2 = depth[favorite[i]];
                    maxTwoCycleSum += depth1 + depth2 + 2;
                } else {
                    maxCycle = Math.max(maxCycle, cycleSize);
                }
            }
        }

        return Math.max(maxCycle, maxTwoCycleSum);
    }
}
