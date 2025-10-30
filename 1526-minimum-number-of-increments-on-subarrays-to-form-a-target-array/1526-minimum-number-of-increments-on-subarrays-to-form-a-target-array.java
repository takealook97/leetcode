class Solution {
    public int minNumberOperations(int[] target) {
        int answer = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                answer += target[i] - target[i - 1];
            }
        }
        
        return answer;
    }
}
