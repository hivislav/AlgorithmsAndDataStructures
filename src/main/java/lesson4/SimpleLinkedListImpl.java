package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {
    protected Node<E> first;
    protected Node<E> last;
    protected int size;


    @Override
    public void insertFirst(E value) {
        Node<E> temp = last;
        Node<E> newNode = new Node<E>(temp, value,null);
        last = newNode;
        if(first == null){
            first = newNode;
        }else{
            temp.next = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            last = null;
            return null;
        }
        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;

        size--;
        return removedNode.value;
    }

    public E removeLast() {
        if(isEmpty()){
            last = null;
            return null;
        }
        Node<E> removedNode = last;
        last = removedNode.prev;
        removedNode.next = null;

        size--;
        return removedNode.value;
    }



    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = first;

        while(current != null){
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null){
            return false;
        }
        if (current == first){
            removeFirst();
            return true;
        }
        if (current == last){
            last = previous;
            last.next = null;
            return true;
        }

        previous.prev = current.prev;
        previous.next = current.next;
        current.next = null;
        size--;
        return true;
    }


    /**
     * Задание №3.
     * Реализовать метод insert в классе списка
     */

    public boolean insert (E valuePos, E value) {
        Node<E> previous = null;
        Node<E> current = first;

        while(current != null){
            if (current.value.equals(valuePos)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null){
            return false;
        }
        if (current == first){
            insertFirst(value);
            return true;
        }

        if (current == last){
            insertLast(value);
            return true;
        }

        current.prev = current;
        current.next = new Node<E>(current.prev, value, current.next);
        size++;
        return true;
    }



    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
    }

    private Node<E> indexOf(E value){
        Node<E> current = first;

        while(current != null){
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;

        while(current != null){
            sb.append(current.value);
            if (current.next != null){
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.value;
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        Node<E> newNode = new Node<>(last, value, null);
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E getlast() {
        return last.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<E>();
    }

    private class MyListIterator<E> implements Iterator<E> {
        private Node<E> current = (Node<E>) first;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            if (hasNext()) {
                E result = current.value;
                current = current.next;
                return result;
            }
            return null;
        }
    }
}
