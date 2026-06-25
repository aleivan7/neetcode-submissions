class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int value = cache.remove(key);
        cache.put(key, value);
        return value;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            
        } else if(cache.size() >= capacity){
            cache.pollFirstEntry();
        }
        cache.put(key, value);
    }
}