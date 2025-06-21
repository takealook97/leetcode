class Solution {
    static int len, k;
    static int[] arr, sumArr;

    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        len = countMap.size();
        this.k = k;
        arr = new int[len];
        int idx = 0;
        for (int val : countMap.values()) {
            arr[idx++] = val;
        }
        Arrays.sort(arr);

        sumArr = new int[len];
        sumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            answer = Math.min(answer, getCount(i));
        }

        return answer;
    }

    static int getCount(int idx) {
        int limit = arr[idx] + k;
        int count = 0;
        if (idx > 0) {
            count += sumArr[idx - 1];
        }

        for (int i = idx; i < len; i++) {
            if (arr[i] > limit) {
                count += (arr[i] - limit);
            }
        }

        return count;
    }
}
