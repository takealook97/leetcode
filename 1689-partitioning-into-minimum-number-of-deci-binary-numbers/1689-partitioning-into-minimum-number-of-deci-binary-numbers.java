class Solution {
    public int minPartitions(String n) {
        int answer = 0;
        for (char c : n.toCharArray()) {
            int num = c - '0';
            answer = Math.max(answer, num);
            if (answer == 9) {
                return 9;
            }
        }

        return answer;
    }
}
