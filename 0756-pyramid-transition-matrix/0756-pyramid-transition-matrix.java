class Solution {
    static int len;
    static List<String> allowed;
    static char[][] arr;
    static Set<String> fail;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        this.allowed = allowed;
        len = bottom.length();
        arr = new char[len + 1][len + 1];
        fail = new HashSet<>();

        for (int i = 0; i < len; i++) {
            arr[len][i + 1] = bottom.charAt(i);
        }

        return find(len - 1, 1);
    }

    static boolean find(int level, int idx) {
        if (level == 0) return true;

        if (idx > level) {
            String key = new String(arr[level], 1, level);
            if (fail.contains(key)) return false;

            if (find(level - 1, 1)) return true;
            fail.add(key);
            return false;
        }

        char a = arr[level + 1][idx];
        char b = arr[level + 1][idx + 1];

        for (String s : allowed) {
            if (s.charAt(0) == a && s.charAt(1) == b) {
                arr[level][idx] = s.charAt(2);
                if (find(level, idx + 1)) return true;
                arr[level][idx] = 0;
            }
        }

        return false;
    }
}
