class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int[] sumArr = new int[len];
        for (int i = 0; i < len; i++) {
            if(i > 0) {
                sumArr[i] = sumArr[i - 1];
            }
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                sumArr[i]++;
            }
        }

        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];
            answer[idx++] = sumArr[to] - (from > 0 ? sumArr[from - 1] : 0);
        }

        return answer;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
