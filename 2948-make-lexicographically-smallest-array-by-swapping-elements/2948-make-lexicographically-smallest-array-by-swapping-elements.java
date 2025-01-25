class Solution {
    static int[] parent;

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        parent = new int[n];
        make(n);

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));

        for (int i = 0; i < n - 1; i++) {
            int curr = indices[i], next = indices[i + 1];
            if (Math.abs(nums[curr] - nums[next]) <= limit) {
                union(curr, next);
            }
        }

        Map<Integer, List<Integer>> groupToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groupToIndices.putIfAbsent(root, new ArrayList<>());
            groupToIndices.get(root).add(i);
        }

        for (List<Integer> group : groupToIndices.values()) {
            List<Integer> values = new ArrayList<>();
            for (int index : group) values.add(nums[index]);
            Collections.sort(values);
            Collections.sort(group);
            for (int i = 0; i < group.size(); i++) {
                nums[group.get(i)] = values.get(i);
            }
        }

        return nums;
    }

    static void make(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
            return true;
        }
        return false;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
