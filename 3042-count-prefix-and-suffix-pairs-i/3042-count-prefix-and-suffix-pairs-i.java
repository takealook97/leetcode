class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int len = words.length;
        int answer = 0;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (words[i].length() < words[j].length()) {
                    if (isPossible(words[i], words[j])) {
                        answer++;
                    }
                } else {
                    if (words[i].equals(words[j])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    static boolean isPossible(String a, String b) {
        int len = a.length();
        int gap = b.length() - len;

        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (a.charAt(i) != b.charAt(i + gap)) {
                return false;
            }
        }

        return true;
    }
}
