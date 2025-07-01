class Solution {
    public int possibleStringCount(String word) {
        Character prev = null;
        int count = 0;
        for (Character c : word.toCharArray()) {
            if (prev == c) {
                count++;
            }
            prev = c;
        }

        return count + 1;
    }
}
