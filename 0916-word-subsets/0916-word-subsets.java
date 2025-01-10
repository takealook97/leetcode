class Solution {
    static final int SIZE = 26;

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[SIZE];
        int[] temp = new int[SIZE];
        for (String word : words2) {
            Arrays.fill(temp, 0);
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }

            for (int i = 0; i < SIZE; i++) {
                count[i] = Math.max(count[i], temp[i]);
            }
        }

        List<String> answer = new ArrayList<>();
        out:
        for (String word : words1) {
            Arrays.fill(temp, 0);
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }

            for (int i = 0; i < SIZE; i++) {
                if (temp[i] < count[i]) {
                    continue out;
                }
            }

            answer.add(word);
        }

        return answer;
    }
}
