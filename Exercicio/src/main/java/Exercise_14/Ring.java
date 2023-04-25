package Exercise_14;

public class Ring {
    Node current;
    public int size;

    public void add(int number){
        if(size == 0){
            current = new Node(number);
            current.next = current;
            current.prev = current;
        } else{
            Node node = new Node(number);
            node.next = current.next;
            current.next = node;

            node.prev = current;
            node.next.prev = node;

            next();
        }
        size++;


    }
    public int get(){
        return current.value;
    }
    public void next(){
        current = current.next;
    }
    public void prev(){
        current = current.prev;
    }

    public int size() {
        return size;
    }

    public void remove(){
        Node nextNode = current.next;
        Node prevNode = current.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        current = prevNode;

    }
    private static class Node {
        private Node next;
        private Node prev;
        public int value;
        public Node(int val){
            this.value = val;
            next = null;
            prev = null;
        }
    }
}
