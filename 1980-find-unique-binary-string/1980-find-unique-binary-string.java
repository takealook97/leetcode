class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(nums[i], 2);
            if (i > 0) {
                if (arr[i] - arr[i - 1] > 1) {
                    int num = arr[i - 1] + 1;
                    String bin = Integer.toBinaryString(num);
                    int gap = nums[i].length() - bin.length();
                    StringBuilder sb = new StringBuilder();
                    while (gap-- > 0) {
                        sb.append(0);
                    }
                    sb.append(bin);
                    return sb.toString();
                }
            }
        }
        boolean isZero = false;
        if (arr[0] != 0) {
            isZero = true;
        }
        StringBuilder sb = new StringBuilder();
        int length = nums[0].length();
        while(length-- > 0) {
            if (isZero) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        return sb.toString();
    }
}