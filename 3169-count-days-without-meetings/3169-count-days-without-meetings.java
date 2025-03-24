class Solution {
    public int countDays(int days, int[][] meetings) {
        int len = meetings.length;
        Arrays.sort(meetings, (o1, o2) -> {
            return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
        });

        int lo = meetings[0][0], hi = meetings[0][1];
        int answer = lo - 1;
        for (int i = 1; i < len; i++) {
            if (lo == meetings[i][0] || meetings[i][1] <= hi) {
                continue;
            }

            if (meetings[i][0] > hi) {
                answer += (meetings[i][0] - hi - 1);
            }
            lo = meetings[i][0];
            hi = meetings[i][1];
        }

        answer += (days - hi);

        return answer;
    }
}
