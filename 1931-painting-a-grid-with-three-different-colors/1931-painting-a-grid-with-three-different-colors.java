class Solution {
    static int m, n;
    static List<int[]> list;
    static Map<Integer, List<Integer>> map;

    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        list = new ArrayList<>();
        map = new HashMap<>();

        generate(new int[m], 0);

        int len = list.size();
        for (int i = 0; i < len; i++) {
            List<Integer> nextList = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (isPossible(list.get(i), list.get(j))) {
                    nextList.add(j);
                }
            }
            map.put(i, nextList);
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int[] nextDp = new int[len];
            for (int cur = 0; cur < len; cur++) {
                for (int prev : map.get(cur)) {
                    nextDp[cur] = (nextDp[cur] + dp[prev]) % MOD;
                }
            }
            dp = nextDp;
        }

        int answer = 0;
        for (int val : dp) {
            answer = (answer + val) % MOD;
        }

        return answer;
    }

    static void generate(int[] arr, int idx) {
        if (idx == m) {
            list.add(Arrays.copyOf(arr, m));
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (0 < idx && arr[idx - 1] == color) {
                continue;
            }
            arr[idx] = color;
            generate(arr, idx + 1);
        }
    }

    static boolean isPossible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                return false;
            }
        }

        return true;
    }
}
