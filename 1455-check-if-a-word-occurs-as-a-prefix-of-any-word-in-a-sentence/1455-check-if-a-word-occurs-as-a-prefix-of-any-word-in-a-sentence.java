class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int len = arr.length;
        int wordLen = searchWord.length();

        out:
        for (int i = 0; i < len; i++) {
            if (arr[i].length() < wordLen) {
                continue;
            }

            for (int j = 0; j < wordLen; j++) {
                if (arr[i].charAt(j) != searchWord.charAt(j)) {
                    continue out;
                }
            }

            return i + 1;
        }

        return -1;
    }
}
