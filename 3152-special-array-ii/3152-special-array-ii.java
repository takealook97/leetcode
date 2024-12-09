class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int len = nums.length;
        if (len <= 1) {
            boolean[] answer = new boolean[queries.length];
            Arrays.fill(answer, true);
            return answer;
        }

        boolean[] isSpecial = new boolean[len];
        for (int i = 1; i < len; i++) {
            isSpecial[i] = nums[i - 1] % 2 != nums[i] % 2;
        }

        int[] sumArr = new int[len];
        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i - 1] + (isSpecial[i] ? 0 : 1);
        }

        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = (sumArr[queries[i][0]] - sumArr[queries[i][1]] == 0);
        }

        return answer;
    }
}
