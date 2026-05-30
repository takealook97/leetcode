class Solution {
    public int minElement(int[] nums) {
        int answer = Integer.MAX_VALUE;
        for (int num : nums) {
            String s = Integer.toString(num);
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += c - '0';
            }

            answer = Math.min(answer, sum);
        }
        
        return answer;
    }
}
