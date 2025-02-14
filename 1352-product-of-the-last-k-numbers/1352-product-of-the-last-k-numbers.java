class ProductOfNumbers {
    static List<Integer> list, sub;
    static int size;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        size = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            list.add(num);
            size++;
            return;
        }

        int last = size <= 0 ? 1 : list.get(size - 1);
        list.add(last == 0 ? num : last * num);
        size++;
    }
    
    public int getProduct(int k) {
        if (list.subList(size - k, size).contains(0)) {
            return 0;
        }

        int last = list.get(size - 1);
        int lo = size == k ? 1 : list.get(size - k - 1);
        return last / (lo > 0 ? lo : 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */