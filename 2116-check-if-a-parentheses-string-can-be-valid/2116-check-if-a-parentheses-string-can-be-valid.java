class Solution {
    static final char OPEN = '(', CLOSE = ')', UNLOCKED = '0';

    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        int count = 0;
        int changable = 0;

        for (int i = 0; i < len; i++) {
            if (locked.charAt(i) == UNLOCKED) {
                changable++;
            } else if (s.charAt(i) == OPEN) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else if (changable > 0) {
                    changable--;
                } else {
                    return false;
                }
            }
        }

        if (count > changable) {
            return false;
        }

        count = 0;
        changable = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (locked.charAt(i) == UNLOCKED) {
                changable++;
            } else if (s.charAt(i) == CLOSE) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else if (changable > 0) {
                    changable--;
                } else {
                    return false;
                }
            }
        }

        return count <= changable;
    }
}
