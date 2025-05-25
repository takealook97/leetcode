class Solution {
    static final int SIZE = 26;

    public int longestPalindrome(String[] words) {
        int[][] count = new int[SIZE][SIZE];
        for (String word : words) {
            count[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }

        int answer = 0;
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                int min = Math.min(count[i][j], count[j][i]);
                if (min > 0) {
                    answer += (min * 4);
                }
            }
        }

        boolean check = false;
        for (int i = 0; i < SIZE; i++) {
            if (count[i][i] > 1) {
                answer += ((count[i][i] / 2) * 4);
                if (count[i][i] % 2 == 1) {
                    check = true;
                }
            } else if (count[i][i] == 1) {
                check = true;
            }
        }

        if (check) answer += 2;

        return answer;
    }
}
