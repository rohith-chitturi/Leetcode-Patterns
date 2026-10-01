class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        Node(int key,int val){
            this.key=key;
            this.val=val;
            prev=null;
            next=null;
        }
    }
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    private void addNode(Node node){
        node.prev=tail.prev;
        node.next=tail;
        tail.prev.next=node;
        tail.prev=node;
    }
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
           return -1;
        }
        Node gotvalue= map.get(key);
        removeNode(gotvalue);
        addNode(gotvalue);
        return gotvalue.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            removeNode(node);
            addNode(node);
        }else{
        Node node=new Node(key,value);
        map.put(key,node);
        addNode(node);
        if(map.size()>capacity){
            Node LRU=head.next;
            removeNode(LRU);
            map.remove(LRU.key);
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