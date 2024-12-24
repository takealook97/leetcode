class Solution {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int maxDepth, farthestNode;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        if (edges1.length == 0 && edges2.length == 0) return 1;
        if (edges1.length == 0) return getDiameter(edges2);
        if (edges2.length == 0) return getDiameter(edges1);
        int d1 = getDiameter(edges1);
        int d2 = getDiameter(edges2);
        int c1 = (d1 + 1) / 2;
        int c2 = (d2 + 1) / 2;
        return Math.max(Math.max(d1, d2), c1 + c2 + 1);
    }

    static int getDiameter(int[][] edges) {
        if (edges.length == 0) return 0;
        int n = edges.length + 1;
        initTree(n, edges);
        visited = new boolean[n];
        maxDepth = 0;
        find(0, 0);
        Arrays.fill(visited, false);
        maxDepth = 0;
        find(farthestNode, 0);
        return maxDepth;
    }

    static void initTree(int n, int[][] edges) {
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
    }

    static void find(int node, int depth) {
        visited[node] = true;
        if (depth > maxDepth) {
            maxDepth = depth;
            farthestNode = node;
        }
        for (int nxt : tree[node]) {
            if (!visited[nxt]) find(nxt, depth + 1);
        }
    }
}
