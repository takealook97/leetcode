class Solution {
    public int prefixCount(String[] words, String pref) {
        int len = pref.length();
        int answer = 0;

        out:
        for (String word : words) {
            if (word.length() < len) {
                continue;
            }

            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != pref.charAt(i)) {
                    continue out;
                }
            }
            
            answer++;
        }

        return answer;
    }
}
