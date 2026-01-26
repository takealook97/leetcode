class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                answer.add(list);
            }
        }

        return answer;
    }
}
