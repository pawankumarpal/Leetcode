class MyHashMap {
private int[] hashData = new int[1000001];

    public MyHashMap() {
        Arrays.fill(hashData,-1);
    }
    
    public void put(int key, int value) {
        hashData[key]= value;
    }
    
    public int get(int key) {
        return hashData[key];
    }
    
    public void remove(int key) {
        hashData[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */