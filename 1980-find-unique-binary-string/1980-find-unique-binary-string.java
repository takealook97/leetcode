class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        int size = (int) Math.pow(2, nums[0].length());
        int[] arr = new int[len];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(nums[i], 2);
        }
        Arrays.sort(arr);
        
        for (int i = 0; i < len; i++) {
            visited[arr[i]] = true;
        }

        String answer = null;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                answer = Integer.toBinaryString(i);
                break;
            }
        }

        int gap = nums[0].length() - answer.length();
        if (gap == 0) {
            return answer;
        }

        StringBuilder sb = new StringBuilder();
        while (gap-- > 0) {
            sb.append(0);
        }
        sb.append(answer);

        return sb.toString();
    }
}
