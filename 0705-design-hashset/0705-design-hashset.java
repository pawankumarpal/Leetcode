class MyHashSet {
    private boolean[] boolData = new boolean[1000001];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        boolData[key] = true;
    }
    
    public void remove(int key) {
        boolData[key] = false;
    }
    
    public boolean contains(int key) {
        return boolData[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */