class Solution {
    static int len;
    static int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        len = edges.length;
        
        make();

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }

        return null;
    }

    static void make() {
        parent = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
            return true;
        }

        return false;
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
