class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0, len = bits.length;
        while (idx < len - 1) {
            idx += bits[idx] == 1 ? 2 : 1;
        }

        return idx == len - 1;
    }
}
