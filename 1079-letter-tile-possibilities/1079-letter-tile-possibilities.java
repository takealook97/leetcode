class Solution {
    static int len;
    static Set<String> set;
    static char[] arr;
    static boolean[] visited;

    public int numTilePossibilities(String tiles) {
        len = tiles.length();
        set = new HashSet<>();
        arr = tiles.toCharArray();
        visited = new boolean[len];
        find(new StringBuilder());

        return set.size() - 1;
    }

    static void find(StringBuilder sb) {
        if (sb.length() > len) {
            return;
        }

        set.add(sb.toString());
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(arr[i]);
                find(sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
