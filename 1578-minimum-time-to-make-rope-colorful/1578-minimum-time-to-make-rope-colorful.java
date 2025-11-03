class Solution {
    public int minCost(String colors, int[] neededTime) {
        int len = colors.length();
        char cur = colors.charAt(0), now;
        int sum = 0, max = neededTime[0], answer = 0;

        for (int i = 0; i < len; i++) {
            now = colors.charAt(i);
            if (now == cur) {
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            } else {
                answer += (sum - max);

                cur = now;
                sum = neededTime[i];
                max = neededTime[i];
            }
        }

        answer += (sum - max);

        return answer;
    }
}