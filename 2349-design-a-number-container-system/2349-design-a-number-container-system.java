class NumberContainers {
    static Map<Integer, Integer> idxMap;
    static Map<Integer, TreeSet<Integer>> numMap;

    public NumberContainers() {
        idxMap = new HashMap<>();
        numMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (idxMap.containsKey(index)) {
            int prev = idxMap.get(index);
            numMap.get(prev).remove(index);
            if (numMap.get(prev).isEmpty()) {
                numMap.remove(prev);
            }
        }

        idxMap.put(index, number);
        numMap.putIfAbsent(number, new TreeSet<>());
        numMap.get(number).add(index);
    }
    
    public int find(int number) {
        if (numMap.containsKey(number) && !numMap.get(number).isEmpty()) {
            return numMap.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */