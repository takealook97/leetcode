class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int len = tops.length;
        int[] count = new int[6];
        for (int i = 0; i < len; i++) {
            count[tops[i] - 1]++;
            count[bottoms[i] - 1]++;
        }
        
        int max = 0, num = -1;
        for (int i = 0; i < 6; i++) {
            if (max < count[i]) {
                max = count[i];
                num = i + 1;
            }
        }

        int topCount = 0, bottomCount = 0;
        for (int i = 0; i < len; i++) {
            if (tops[i] == num) {
                if (bottoms[i] != num) {
                    bottomCount++;
                }
            } else if (bottoms[i] == num) {
                if (tops[i] != num) {
                    topCount++;
                }
            } else {
                return -1;
            }
        }

        return Math.min(topCount, bottomCount);
    }
}