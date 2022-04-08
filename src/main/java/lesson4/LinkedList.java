package lesson4;

public interface LinkedList <E>{

    void insertFirst (E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    //для операций с последним элементом списка

    void insertLast(E value);
    E getlast();
}
