class Solution {
    public String clearDigits(String s) {
        int len = s.length();
        boolean[] visited = new boolean[len];
        for (int hi = 0; hi < len; hi++) {
            int num = (int) (s.charAt(hi) - '0');
            if (0 <= num && num < 10) {
                visited[hi] = true;
                int lo = hi;
                while (0 < lo--) {
                    if (10 <= (int) (s.charAt(lo) - '0') && !visited[lo]) {
                        visited[lo] = true;
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
