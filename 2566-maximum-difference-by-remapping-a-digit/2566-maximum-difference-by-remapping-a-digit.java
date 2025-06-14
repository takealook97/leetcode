class Solution {
    public int minMaxDifference(int num) {
        String numStr = Integer.toString(num);
        int len = numStr.length();
        int[] count = new int[len];

        int maxTarget = -1, minTarget = numStr.charAt(0) - '0';
        for (int i = 0; i < len; i++) {
            maxTarget = numStr.charAt(i) - '0';
            if (maxTarget < 9) {
                break;
            }
        }

        int max = 0, min = 0;
        for (int i = 0; i < len; i++) {
            int n = numStr.charAt(i) - '0';
            if (n == maxTarget) {
                max += 9 * Math.pow(10, len - i - 1);
            } else {
                max += n * Math.pow(10, len - i - 1);
            }

            if (n == minTarget) {
                min += 0 * Math.pow(10, len - i - 1);
            } else {
                min += n * Math.pow(10, len - i - 1);
            }
        }

        return max - min;
    }
}
