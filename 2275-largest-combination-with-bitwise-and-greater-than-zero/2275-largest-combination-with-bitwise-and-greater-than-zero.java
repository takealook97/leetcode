class Solution {
    static final int LIMIT = 25;

    public int largestCombination(int[] candidates) {
        int answer = 0;
        int[] count = new int[LIMIT];

        for (int num : candidates) {
            for (int i = 0; i < LIMIT; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }

        for (int cnt : count) {
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
