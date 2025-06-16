// dll
class Node {
    int key, value;
    Node next, prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}

class LRUCache {
    int cap;
    Map<Integer, Node> map;
    Node lru, mru;
    // -- auxiliary/helper functions -- // 
    void insert(Node n) {           // disconnects the node
        Node tail = mru.prev;
        tail.next = n;
        mru.prev = n;
        n.prev = tail;
        n.next = mru;
    }
    void remove(Node n) {           // inserts the node to the left of mru
        Node next = n.next;
        Node prev = n.prev;
        next.prev = prev;
        prev.next = next;
    }
    // -- //

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        lru = new Node(-1, -1);
        mru = new Node(-1, -1);
        lru.next = mru;
        mru.prev = lru;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insert(n);
            n.value = value;
        }
        else {
            Node n = new Node(key, value);
            map.put(key, n);
            insert(n);
            if(map.size() > cap) {
                Node temp = lru.next;
                map.remove(temp.key);
                remove(temp);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */