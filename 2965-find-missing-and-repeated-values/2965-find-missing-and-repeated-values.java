class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int len = grid.length;
        int[] answer = new int[2];
        int[] count = new int[len * len + 1];
        for (int[] arr : grid) {
            for (int num : arr) {
                count[num]++;
            }
        }

        for (int i = 1; i <= len * len; i++) {
            if (count[i] == 2) {
                answer[0] = i;
            } else if (count[i] == 0) {
                answer[1] = i;
            }
        }

        return answer;
    }
}
