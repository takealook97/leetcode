class Solution {
    static int len;
    static int[][][] count;

    static final int UPPER = 0, LOWER = 1, A = 0, B = 1, C = 2;

    public int takeCharacters(String s, int k) {
        len = s.length();

        if (k <= 0) {
            return 0;
        } else if (len <= 2) {
            return -1;
        }

        count = new int[2][3][len + 1];

        for (int i = 1; i <= len; i++) {
            int j = len - i;
            count[UPPER][A][i] += count[UPPER][A][i - 1];
            count[UPPER][B][i] += count[UPPER][B][i - 1];
            count[UPPER][C][i] += count[UPPER][C][i - 1];
            
            count[LOWER][A][i] += count[LOWER][A][i - 1];
            count[LOWER][B][i] += count[LOWER][B][i - 1];
            count[LOWER][C][i] += count[LOWER][C][i - 1];

            char upAlphabet = s.charAt(i - 1);
            if(upAlphabet == 'a') {
                count[UPPER][A][i]++;
            } else if (upAlphabet == 'b') {
                count[UPPER][B][i]++;
            } else {
                count[UPPER][C][i]++;
            }

            char downAlphabet = s.charAt(j);
            if(downAlphabet == 'a') {
                count[LOWER][A][i]++;
            } else if (downAlphabet == 'b') {
                count[LOWER][B][i]++;
            } else {
                count[LOWER][C][i]++;
            }
        }

        return find(k);
    }

    static int find(int limit) {
        int downIdx = 0, sumA ,sumB, sumC;
        int answer = Integer.MAX_VALUE;

        for (int upIdx = len; upIdx >= 0; upIdx--) {
            while (downIdx <= len) {
                sumA = count[UPPER][A][upIdx] + count[LOWER][A][downIdx];
                sumB = count[UPPER][B][upIdx] + count[LOWER][B][downIdx];
                sumC = count[UPPER][C][upIdx] + count[LOWER][C][downIdx];

                if (sumA >= limit && sumB >= limit && sumC >= limit) {
                    if(upIdx + downIdx <= len) {
                        answer = Math.min(answer, upIdx + downIdx);
                    }

                    break;
                }

                downIdx++;
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
