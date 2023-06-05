package Exercise_14;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ring<T> implements Iterable<T> {
    Node current;
    public int size;

    public void add(T object){
        if(size == 0){
            current = new Node(object);
            current.next = current;
            current.prev = current;
        } else{
            Node node = new Node(object);
            node.next = current.next;
            current.next = node;

            node.prev = current;
            node.next.prev = node;

            next();
        }
        assert (current == null) : "Elemento nulo";
        size++;
    }
    public T get(){
        if (size() == 0){
            throw new EmptyRingException("could not get the element");
        }
        return current.value;
    }

    public void remove(){
        if (size() == 0){
            throw new EmptyRingException("could not remove because the ring is empty");
        }


        Node nextNode = current.next;
        Node prevNode = current.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        current = prevNode;
    }
    public void next(){
        if (size() == 0){
            throw new EmptyRingException("it was not possible to go to the next one, because the ring is empty");
        }
        current = current.next;
    }

    public void prev(){
        if (size() == 0){
            throw new EmptyRingException("it was not possible to go to the previous one, because the ring is empty");
        }
        current = current.prev;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(current.value);
            next();
        }
        return list.iterator();
    }

    private class Node {
        private Node next;
        private Node prev;
        public T value;
        public Node(T val){
            this.value = val;
            next = null;
            prev = null;
        }
    }
}
