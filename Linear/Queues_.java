import java.util.Optional;

public class Queues_<T> {

    private final Linked_List<T> linkedList;

    public Queues_() {
        linkedList = new Linked_List<>();
    }

    public void enqueue(T item) {
        linkedList.add(item);
    }

    public void dequeue() {
        linkedList.removeFront();
    }

    public Optional<Node<T>> getFront() {
        return linkedList.getHead();
    }

    public Optional<Node<T>> getLast() {
        return linkedList.getTail();
    }

    public void reverse() {
        linkedList.reverse();
    }

    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

}
