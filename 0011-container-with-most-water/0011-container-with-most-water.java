class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int answer = 0;

        while (lo < hi) {
            answer = Math.max(answer, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }

        return answer;
    }
}
