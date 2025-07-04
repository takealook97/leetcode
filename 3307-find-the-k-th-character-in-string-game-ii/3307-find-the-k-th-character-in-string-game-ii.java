class Solution {
    public char kthCharacter(long k, int[] operations) {
        k--;
        long len = 1;
        List<Long> lengths = new ArrayList<>();
        for (int operation : operations) {
            len *= 2;
            lengths.add(len);
        }

        int shift = 0;
        for (int i = operations.length - 1; i >= 0; i--) {
            long mid = lengths.get(i) / 2;
            if (k >= mid) {
                k -= mid;
                if (operations[i] == 1) shift++;
            }
        }

        return (char) ((shift % 26) + 'a');
    }
}
