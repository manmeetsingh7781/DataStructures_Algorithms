package com.company.DynamicDS;

import java.util.Optional;


class Node<T> {
    private T data;
    private Node<T> next, previous;
    
    public Node(T value) {
        setData(value);
    }


    public Node(T value, Node<T> next, Node<T> previous){
        setData(value);
        setNext(next);
        setPrevious(previous);
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public Node<T> getNext() {
        return next;
    }


    public Node<T> getPrevious() {
        return previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}

public class Linked_List<T> {

    private Optional<Node<T>> head, tail;
    private int size;


    public Linked_List() {
        this.head = Optional.<Node<T>>empty();
        this.tail = Optional.<Node<T>>empty();
        size = 0;
    }


    // T(n) = O(1)
    public void add(T item){
        Node<T> newNode = new Node<>(item, null, null);

        // if the list is empty then we set the new node and head, tail to point at it
        // head.isEmpty() is same as head == null
        if(head.isEmpty() && tail.isEmpty()){
            head = Optional.of(newNode);
            tail = head;
            size++;
        }else if(head.isPresent() && tail.isPresent()){     // head.isPresent() is same as head != null

            newNode.setPrevious(tail.get());
            newNode.setNext(tail.get().getNext());

            tail.get().setNext(newNode);
            tail = Optional.of(newNode);
            size++;

        }

    }

    // T(n) = O(1)
    public void addFront(T item){
        if(head.isEmpty() && tail.isEmpty() || head.equals(tail)){
           add(item);
        }else {

            // Functional Approach
            Node<T> newNode = new Node<>(item,   null, head.orElse(null));


            head.ifPresent(pre-> pre.setPrevious(newNode)); // set the previous before we change the state of head
            head = Optional.of(newNode);
            size++;
        }
    }

    public void removeFront(){
        removeAt(0);
    }

    public void removeLast(){
        removeAt(size-1);
    }

    // reverse by values T(n) = O(log(n))
    //S(T) = O(1)
    /*
    * if the iterator is divided / multiplied by a constant amount K
    * \ then the time complexity is considered as O(logK N)
    * */
    public void reverse(){

        int i = 0;
        T temp_value;
        Optional<Node<T>> temp_head = head, temp_tail = tail;

        while (i != (size/2) && temp_head.isPresent() && temp_tail.isPresent()){

            //swap
            temp_value = temp_head.get().getData();
            temp_head.get().setData(temp_tail.get().getData());
            temp_tail.get().setData(temp_value);

            // update head and tail
            temp_head = Optional.ofNullable(temp_head.get().getNext());
            temp_tail = Optional.ofNullable(temp_tail.get().getPrevious());

            i++;

        }

    }



    // remove using given index
    public void removeAt(int index){
        Optional<Node<T>> nodeToRemove = getNode(index);
        if(nodeToRemove.isPresent()) {

            if (index <= 0) {

                head = Optional.ofNullable(nodeToRemove.get().getNext());

            } else if (index >= size - 1 && tail.isPresent()) {
                tail = Optional.ofNullable(tail.get().getPrevious());
                tail.ifPresent(tNode -> tNode.setNext(null));

            } else {

                // node to remove is between head and tail
                Optional<Node<T>> beforeRemove = Optional.ofNullable(nodeToRemove.get().getPrevious());
                Optional<Node<T>> nextRemove = Optional.ofNullable(nodeToRemove.get().getNext());


                beforeRemove.ifPresent(bNode-> bNode.setNext(nextRemove.orElse(null)));
                nextRemove.ifPresent(nNode -> nNode.setPrevious(beforeRemove.orElse(null)));

            }

            eraseNode(nodeToRemove.get());
            nodeToRemove = Optional.empty();    //garbage collector will remove the junk itself
            size--;
        }

    }


    private void eraseNode(Node<T> aNode){
        aNode.setPrevious(null);
        aNode.setNext(null);
        aNode.setData(null);
    }


    private Optional<Node<T>> getNode(int index){
        if(index <= 0) return head;
        else if(index >= size-1) return tail;
        else{
            int iter = 0;
            Optional<Node<T>> node = head;
            while (iter < index && (node.isPresent())) {
                node = Optional.ofNullable(node.get().getNext());
                iter++;
            }

            return node;
        }
    }

    public int getSize() {
        return size;
    }

    public Optional<Node<T>> getHead() {
        return head;
    }



    public void setHead(Optional<Node<T>> head) {
        this.head = head;
    }

    public Optional<Node<T>> getTail() {
        return tail;
    }

    public void setTail(Optional<Node<T>> tail) {
        this.tail = tail;
    }

    @Override
    public String toString(){
        String str  = "[";
        var temp = head;
        while (temp.isPresent()){
            str += temp.get().getData();
            if(temp.get().getNext() != null) str += ", ";
            temp = Optional.ofNullable(temp.get().getNext());
        }
        return str+"]";
    }


    // T(n) = O(log(n))
    /*
     * if the iterator is divided / multiplied by a constant amount K
     * \ then the time complexity is considered as O(logK N)
     * */
    // Two pointers are working together to find an element
    public boolean contains(T value) {
        int i = 0;
        Optional<Node<T>> temp_head = head, temp_tail = tail;

        if(size < 2){
            return
                    head.filter(item-> item.getData().equals(value)).isPresent()
                    || tail.filter(item-> item.getData().equals(value)).isPresent();
        }else {

            while (i != (size / 2) && temp_head.isPresent() && temp_tail.isPresent()) {

                if (temp_head.get().getData().equals(value) || temp_tail.get().getData().equals(value))
                    return true;

                // update head and tail
                temp_head = Optional.ofNullable(temp_head.get().getNext());
                temp_tail = Optional.ofNullable(temp_tail.get().getPrevious());

                i++;

            }
        }

        return false;
    }

}
