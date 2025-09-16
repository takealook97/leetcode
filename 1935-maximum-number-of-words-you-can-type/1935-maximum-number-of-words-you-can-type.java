class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int answer = 0;
        out:
        for (String s : arr) {
            for (char c : s.toCharArray()) {
                if (brokenLetters.contains(Character.toString(c))) {
                    continue out;
                }
            }
            answer++;
        }

        return answer;
    }
}
