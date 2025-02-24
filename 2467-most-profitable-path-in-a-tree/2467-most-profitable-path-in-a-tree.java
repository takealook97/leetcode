class Solution {
    static List<Integer>[] graph;
    static int[] parent;
    static int[] dist;
    static int n;
    static int maxProfit;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = amount.length;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        parent = new int[n];
        Arrays.fill(parent, -1);
        bfsParent(0);
        dist = new int[n];
        Arrays.fill(dist, -1);
        setBobDist(bob);
        maxProfit = Integer.MIN_VALUE;
        dfsForAlice(0, -1, 0, 0, amount);
        return maxProfit;
    }

    private void bfsParent(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    parent[nxt] = cur;
                    q.offer(nxt);
                }
            }
        }
    }

    private void setBobDist(int bob) {
        int time = 0;
        int cur = bob;
        while (cur != -1) {
            dist[cur] = time++;
            cur = parent[cur];
        }
    }

    private void dfsForAlice(int node, int p, int time, int profit, int[] amount) {
        int b = dist[node];
        int gain;
        if (b == -1) gain = amount[node];
        else if (time < b) gain = amount[node];
        else if (time == b) gain = amount[node] / 2;
        else gain = 0;
        int newProfit = profit + gain;
        boolean leaf = true;
        for (int nxt : graph[node]) {
            if (nxt == p) continue;
            leaf = false;
            dfsForAlice(nxt, node, time + 1, newProfit, amount);
        }
        if (leaf) {
            maxProfit = Math.max(maxProfit, newProfit);
        }
    }
}
