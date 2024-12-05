class Solution {
    static int startLength, targetLength;
    static char[] startArr, targetArr;

    static final char RIGHT = 'R', LEFT = 'L', BLANK = '_';

    public boolean canChange(String start, String target) {
        startLength = start.length();
        targetLength = target.length();
        startArr = start.toCharArray();
        targetArr = target.toCharArray();

        int i = 0, j = 0;

        while (i < startLength || j < targetLength) {
            while (i < startLength && startArr[i] == BLANK) {
                i++;
            }
            while (j < targetLength && targetArr[j] == BLANK) {
                j++;
            }

            if (i == startLength && j == targetLength) {
                return true;
            }

            if (i == startLength || j == targetLength || startArr[i] != targetArr[j]) {
                return false;
            }

            if (startArr[i] == LEFT && i < j) {
                return false;
            }

            if (startArr[i] == RIGHT && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}
