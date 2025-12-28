class Solution {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for (int[] arr : grid) {
            for (int num : arr) {
                if (num < 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
