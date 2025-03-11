class Solution {
    static String s;
    static int a, b, c;

    public int numberOfSubstrings(String s) {
        this.s = s;
        int len = s.length(), lo = 0, hi = 1, answer = 0;
        a = 0;
        b = 0;
        c = 0;
        
        count(0, true);
        boolean loIncreased = false;

        while (hi < len) {
            if (!loIncreased) count(hi, true);

            if (a > 0 && b > 0 && c > 0) {
                answer += (len - hi);
                count(lo, false);
                lo++;
                loIncreased = true;
            } else {
                hi++;
                loIncreased = false;
            }
        }

        return answer;
    }

    static void count(int idx, boolean isAdd) {
        char alphabet = s.charAt(idx);
        if (alphabet == 'a') {
            if (isAdd) {
                a++;
            } else {
                a--;
            }
        } else if (alphabet == 'b') {
            if (isAdd) {
                b++;
            } else {
                b--;
            }
        } else {
            if (isAdd) {
                c++;
            } else {
                c--;
            }
        }
    }
}