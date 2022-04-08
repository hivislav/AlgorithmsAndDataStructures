package lesson4;

public interface Deque <E>{

    boolean insert(E value);

    E remove ();

    E peekFront();

    boolean insertEnd(E value);

    E removeEnd ();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
