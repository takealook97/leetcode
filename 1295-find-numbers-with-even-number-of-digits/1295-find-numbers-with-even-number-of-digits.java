class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;
        String numStr;
        for (int num : nums) {
            numStr = Integer.toString(num);
            if (numStr.length() % 2 == 0) {
                answer++;
            }
        }

        return answer;
    }
}
