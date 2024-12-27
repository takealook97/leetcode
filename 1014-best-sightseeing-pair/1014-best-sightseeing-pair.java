class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0];
        int answer = 0;

        for (int i = 1; i < values.length; i++) {
            answer = Math.max(answer, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }

        return answer;
    }
}
