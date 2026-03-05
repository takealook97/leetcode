class Solution {
    public int minOperations(String s) {
        int len = s.length();
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < len; i += 2) {
            if (s.charAt(i) == '0') {
                a++;
            } else {
                b++;
            }
            if (i + 1 >= len) {
                break;
            }
            if (s.charAt(i + 1) == '1') {
                c++;
            } else {
                d++;
            }
        }

        return Math.min(a + c, b + d);
    }
}
