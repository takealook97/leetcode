class Solution {
    public String addSpaces(String s, int[] spaces) {
        int stringLen = s.length();
        int spaceArrLen = spaces.length;
        Arrays.sort(spaces);
        int spaceIdx = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringLen; i++) {
            if (spaceIdx < spaceArrLen && i == spaces[spaceIdx]) {
                sb.append(" ");
                spaceIdx++;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
