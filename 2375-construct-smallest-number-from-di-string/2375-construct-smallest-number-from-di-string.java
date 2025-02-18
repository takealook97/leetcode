class Solution {
    static int len;
    static String pattern, answer;
    static boolean[] visited;

    public String smallestNumber(String pattern) {
        len = pattern.length();
        this.pattern = pattern;
        answer = null;
        visited = new boolean[10];

        for (int i = 1; i <= 9; i++) {
            visited[i] = true;
            find(0, Integer.toString(i));
            visited[i] = false;
        }

        return answer;
    }

    static void find(int idx, String num) {
        if (answer != null) {
            return;
        }

        if (idx >= len) {
            answer = num;
            return;
        }

        int last = num.charAt(num.length() - 1) - '0';

        if (pattern.charAt(idx) == 'I') {
            for (int i = last + 1; i <= 9; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    find(idx + 1, num + i);
                    visited[i] = false;
                }
            }
        } else {
            for (int i = 1; i < last; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    find(idx + 1, num + i);
                    visited[i] = false;
                }
            }
        }
    }
}
