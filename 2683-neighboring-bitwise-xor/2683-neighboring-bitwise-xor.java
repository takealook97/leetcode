class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int len = derived.length;
        int start = 0, now = 0;
        int next = derived[0] == 1 ? 1 : 0;

        if (check(len, start, now, next, derived)) {
            return true;
        }

        start = 1;
        now = 1;
        next = derived[0] == 1 ? 0 : 1;

        if (check(len, start, now, next, derived)) {
            return true;
        }

        return false;
    }

    static boolean check(int len, int start, int now, int next, int[] derived) {
        int temp = 0;

        for (int i = 0; i < len; i++) {
            if (i > 0) {
                now = next;
            }

            if (i >= len - 1) {
                next = start;
                return (now ^ start) == derived[i];
            }

            if (derived[i] == 0) {
                next = now;
            } else {
                if (now == 1) {
                    next = 0;
                } else {
                    next = 1;
                }
            }
        }

        return false;
    }
}
