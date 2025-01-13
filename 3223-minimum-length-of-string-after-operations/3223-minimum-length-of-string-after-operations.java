class Solution {
    public int minimumLength(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] >= 3) {
                if (count[i] % 2 == 1) {
                    count[i] = 1;
                } else {
                    count[i] = 2;
                }
            }
        }

        int answer = 0;
        for (int i : count) {
            answer += i;
        }

        return answer;
    }
}
