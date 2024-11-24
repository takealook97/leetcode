class Solution {

    public long maxMatrixSum(int[][] matrix) {
        long answer = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int[] arr : matrix) {
            for (int num : arr) {
                answer += Math.abs(num);
                if (num < 0) {
                    count++;
                }
                min = Math.min(min, Math.abs(num));
            }
        }

        if (count % 2 != 0) {
            answer -= 2 * min;
        }

        return answer;
    }
}
