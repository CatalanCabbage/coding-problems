/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/lru-cache/
 * Statement: Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * LRU Cache ref: https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU
 * Discussions soln ref: https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-+-Double-linked-list-(with-a-touch-of-pseudo-nodes)/249529
 * <p>
 * Solution:
 * Store key-Node mapping in a HashMap.
 * When a key is accessed, move corresponding Node to the head of a linkedList<Node>.
 * To eject least recently used value - remove tail of LinkedList and remove corresponding key from HashMap.
 */

class LRUCache {

    private LinkedNodeList list;
    private HashMap<Integer, Node> map;
    private int capacity;

    //Initialize the LRU cache with positive size capacity.
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedNodeList();
        this.map = new HashMap<Integer, Node>();
    }

    //Return the value of the key if the key exists, otherwise return -1.
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.moveToHead(node);
            return node.val;
        }

        return -1;
    }

    //Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
    //If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            list.moveToHead(node);
        } else {
            if (map.size() == capacity) {
                //Remove oldest value
                Node node = list.getTail();
                map.remove(node.key);
                list.remove(node);
            }
            Node node = new Node(key, value);
            list.addToHead(node);
            map.put(key, node);
        }
    }

    class LinkedNodeList {
        Node dummyHead;
        Node dummyTail;

        public LinkedNodeList() {
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        public void addToHead(Node node) {
            Node exHead = dummyHead.next;
            exHead.prev = node;
            node.next = exHead;

            dummyHead.next = node;
            node.prev = dummyHead;
        }

        public void remove(Node node) {
            Node exNextNode = node.next;
            exNextNode.prev = node.prev;
            node.prev.next = exNextNode;
            node = null;
        }

        public Node getTail() {
            return dummyTail.prev;
        }

    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
