class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            int num = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int answer = 0;
        for (int count : map.values()) {
            if (count > 1) {
                answer += (count * (count - 1)) / 2;
            }
        }

        return answer;
    }
}
