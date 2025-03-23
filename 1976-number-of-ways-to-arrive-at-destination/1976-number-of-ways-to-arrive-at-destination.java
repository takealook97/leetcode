class Solution {
    static int n;
    static ArrayList<Edge>[] listArr;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    static int[] dist, count;

    static final int INF = Integer.MAX_VALUE, MOD = 1000000007;

    static class Edge implements Comparable<Edge> {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public int countPaths(int n, int[][] roads) {
        this.n = n;
        listArr = new ArrayList[n];
        pq = new PriorityQueue<>();
        visited = new boolean[n];
        dist = new int[n];
        count = new int[n];

        for (int i = 0; i < n; i++) {
            listArr[i] = new ArrayList<>();
        }

        int from, to, weight;
        for (int[] road : roads) {
            from = road[0];
            to = road[1];
            weight = road[2];
            listArr[from].add(new Edge(to, weight));
            listArr[to].add(new Edge(from, weight));
        }

        find();

        return count[n - 1];
    }

    static void find() {
        Arrays.fill(dist, INF);
        dist[0] = 0;
        count[0] = 1;
        pq.add(new Edge(0, 0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if (!visited[now.node]) {
                visited[now.node] = true;

                for (Edge next : listArr[now.node]) {
                    if (!visited[next.node]) {
                        if (dist[next.node] > dist[now.node] + next.weight) {
                            dist[next.node] = dist[now.node] + next.weight;
                            count[next.node] = count[now.node];
                            pq.add(new Edge(next.node, dist[next.node]));
                        } else if (dist[next.node] == dist[now.node] + next.weight) {
                            count[next.node] = (count[next.node] + count[now.node]) % MOD;
                        }
                    }
                }
            }
        }

    }    
}
