class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int len = points.length;
        int answer = 0;
        for (int i = 1; i < len; i++) {
            int prevX = points[i - 1][0];
            int prevY = points[i - 1][1];
            int curX = points[i][0];
            int curY = points[i][1];
            int xGap = Math.abs(prevX - curX);
            int yGap = Math.abs(prevY - curY);
            answer += Math.min(xGap, yGap) + Math.abs(xGap - yGap);
        }

        return answer;
    }        
}
