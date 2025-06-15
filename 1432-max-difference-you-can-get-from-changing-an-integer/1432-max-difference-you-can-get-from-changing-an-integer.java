class Solution {
    public int maxDiff(int num) {
        String numStr = Integer.toString(num);
        int len = numStr.length();

        int maxTarget = -1, minTarget = -1;
        int init = numStr.charAt(0) - '0';

        for (int i = 0; i < len; i++) {
            int target = numStr.charAt(i) - '0';
            if (maxTarget == -1 && target < 9) {
                maxTarget = target;
            }
            if (minTarget == -1) {
                if (i == 0 && target > 1) {
                    minTarget = target;
                } else if (i > 0 && target > 0 && target != 1) {
                    minTarget = target;
                }
            }
            if (maxTarget != -1 && minTarget != -1) {
                break;
            }
        }

        int max = 0, min = 0;
        boolean sameAsInit = minTarget == init;
        for (int i = 0; i < len; i++) {
            int n = numStr.charAt(i) - '0';

            if (n == maxTarget) {
                max += 9 * Math.pow(10, len - i - 1);
            } else {
                max += n * Math.pow(10, len - i - 1);
            }

            if (n == minTarget) {
                if (sameAsInit) {
                    min += 1 * Math.pow(10, len - i - 1);
                } else {
                    if (i == 0) {
                        min += 1 * Math.pow(10, len - i - 1);
                    } else {
                        min += 0 * Math.pow(10, len - i - 1);
                    }
                }
            } else {
                min += n * Math.pow(10, len - i - 1);
            }
        }

        return max - min;
    }
}
