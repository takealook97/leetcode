class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int len = words.length;
        int[] dp = new int[len];
        int[] prev = new int[len];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[j] != groups[i] &&
                    words[j].length() == words[i].length() &&
                    getDiff(words[j], words[i]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }

        int maxIdx = 0;
        for (int i = 1; i < len; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<String> answer = new ArrayList<>();
        while (maxIdx != -1) {
            answer.add(0, words[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        return answer;
    }

    static int getDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
