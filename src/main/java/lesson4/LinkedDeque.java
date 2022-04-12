package lesson4;

public class LinkedDeque <E> implements Deque<E>{

    private final SimpleLinkedListImpl<E> data;

    public LinkedDeque(){
        this.data = new SimpleLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public boolean insertEnd(E value) {
        data.insert(data.getlast(), value);
        return true;
    }

    @Override
    public E removeEnd() {
        return data.removeLast();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedDeque{" + "data =" + data + '}';
    }
}
