package meta;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> dictionary;

   public LRUCache(int capacity) {
        this.capacity = capacity;
        dictionary = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(
                Map.Entry<Integer, Integer> eldest
            ) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        
        return dictionary.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        

      dictionary.put(key,value);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }

    public void printCacheState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printCacheState'");
    }
}