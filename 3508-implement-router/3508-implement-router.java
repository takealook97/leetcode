class Router {
    static int limit, len;
    static Deque<Node> deque;
    static Set<Node> set;
    static Map<Integer, List<Integer>> map;

    static class Node {
        int source, destination, timestamp;

        public Node (int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return this.source == node.source && this.destination == node.destination && this.timestamp == node.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.source, this.destination, this.timestamp);
        }
    }

    public Router(int memoryLimit) {
        limit = memoryLimit;
        deque = new ArrayDeque<>();
        set = new HashSet<>();
        map = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Node node = new Node(source, destination, timestamp);
        if (set.contains(node)) return false;

        len = deque.size();
        if (len >= limit) {
            Node removed = deque.removeFirst();
            set.remove(removed);
            List<Integer> dlist = map.get(removed.destination);
            if (dlist != null && !dlist.isEmpty() && dlist.get(0) == removed.timestamp) {
                dlist.remove(0);
            }
        }

        deque.addLast(node);
        set.add(node);
        map.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (deque.isEmpty()) return new int[]{};
        Node node = deque.removeFirst();
        set.remove(node);
        List<Integer> dlist = map.get(node.destination);
        if (dlist != null && !dlist.isEmpty() && dlist.get(0) == node.timestamp) {
            dlist.remove(0);
        }
        return new int[]{node.source, node.destination, node.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> dlist = map.get(destination);
        if (dlist == null || dlist.isEmpty()) return 0;
        int lo = lowerBound(dlist, startTime);
        int hi = upperBound(dlist, endTime);
        return hi - lo;
    }

    static int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    static int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */