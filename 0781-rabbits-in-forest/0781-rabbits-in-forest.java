class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int size, count, answer = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            size = entry.getKey() + 1;
            count = (entry.getValue() + size - 1) / size;
            answer += (count * size);
        }

        return answer;
    }
}
