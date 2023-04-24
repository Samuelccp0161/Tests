package Exercise_14;

public class Ring {
    Node current;
    Node ff;
    public void add(int number){
        current = new Node(number);
        if (current.value != 0){
        }
        current.next = current;

    }
    public int get(){
        return current.value;
    }
    public void next(){
        current = current.next;
    }
    private static class Node {
        public Node next;
        public int value;
        public Node(int val){
            this.value = val;
            next = null;
        }
    }
}
