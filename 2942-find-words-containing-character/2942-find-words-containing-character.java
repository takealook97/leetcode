class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int len = words.length;
        List<Integer> answer = new ArrayList<>();
        String alphabet = Character.toString(x);
        for (int i = 0; i < len; i++) {
            if (words[i].contains(alphabet)) {
                answer.add(i);
            }
        }

        return answer;
    }
}
