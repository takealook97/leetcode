class Solution {
    static final char BLACK = 'B', WHITE = 'W';

    public int minimumRecolors(String blocks, int k) {
        int answer = Integer.MAX_VALUE, blackCount = 0, whiteCount = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == BLACK) {
                blackCount++;
            } else {
                whiteCount++;
            }
        }

        if (blackCount == k) {
            return 0;
        }

        int lo = 0, hi = k - 1, len = blocks.length();
        while (hi < len) {
            if (whiteCount == 0) {
                return 0;
            }

            answer = Math.min(answer, whiteCount);
            if (blocks.charAt(lo) == BLACK) {
                blackCount--;
            } else {
                whiteCount--;
            }

            lo++;
            if (hi == len - 1) {
                break;
            }
            hi++;
            if (blocks.charAt(hi) == BLACK) {
                blackCount++;
            } else {
                whiteCount++;
            }
        }

        return answer;


        
    }
}
