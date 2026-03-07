class Solution {
    public int minFlips(String s) {
        int len = s.length();
        String ss = s + s;
        int a = 0, b = 0, ans = Integer.MAX_VALUE;

        for (int i = 0; i < ss.length(); i++) {
            char curA = (i % 2 == 0) ? '0' : '1';
            char curB = (i % 2 == 0) ? '1' : '0';

            if (ss.charAt(i) != curA) a++;
            if (ss.charAt(i) != curB) b++;

            if (i >= len) {
                char prevA = ((i - len) % 2 == 0) ? '0' : '1';
                char prevB = ((i - len) % 2 == 0) ? '1' : '0';

                if (ss.charAt(i - len) != prevA) a--;
                if (ss.charAt(i - len) != prevB) b--;
            }

            if (i >= len - 1) {
                ans = Math.min(ans, Math.min(a, b));
            }
        }

        return ans;
    }
}