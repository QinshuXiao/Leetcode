class LRUCache {

    class node{
        node next;
        node prev;
        int val;
        int k;
        node(int key, int v){
            k = key;
            val = v;
        }
    }
    
    private node head;
    private node tail;
    private int capacity;
    private Map<Integer, node> map;
    
    public LRUCache(int capacity) {
        head = new node(0,0);
        tail = new node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<Integer, node>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        node res = map.get(key);
        node prev = res.prev;
        prev.next = res.next;
        res.next.prev = prev;
        res.next = head.next;
        head.next.prev = res;
        head.next = res;
        res.prev = head;
        
        return res.val;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1){
            node n = map.get(key);
            n.val = value;
            return;
        }
        
        node n = new node(key, value);
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
        map.put(key, n);
        
        if(map.size() > capacity){
            node removedNode = tail.prev;
            tail.prev = removedNode.prev;
            removedNode.prev.next = tail;
            map.remove(removedNode.k);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */