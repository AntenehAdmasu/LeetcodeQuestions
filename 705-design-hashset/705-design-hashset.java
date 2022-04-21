class MyHashSet {
String[] myhashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        myhashset = new String[1000001];
    }

    /** value will always be non-negative. */
    public void add(int value) {
        myhashset[value] = ""+value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public void remove(int key) {
        if(myhashset[key] != null) myhashset[key] = null;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public boolean contains(int key) {
        return myhashset[key] != null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */