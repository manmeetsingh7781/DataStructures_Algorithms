package Linear;

import java.util.Optional;

public class Stacks<T> {

    private final Linked_List<T> linkedList;

    public Stacks() {
        linkedList = new Linked_List<>();
    }

    public void push(T item) {
        linkedList.add(item);
    }

    public T pop() {

        return linkedList.getTail().flatMap(e->{        // returning
            T item = e.getData();       // store a value to return
            linkedList.removeLast();    // remove the node
            return Optional.ofNullable(item);       // return the saved value
        }).orElse(null);        // if DNE then return null

    }

    public void reverse() {
        linkedList.reverse();
    }

    public Optional<Node<T>> getTop() {
        return linkedList.getTail();
    }

    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
