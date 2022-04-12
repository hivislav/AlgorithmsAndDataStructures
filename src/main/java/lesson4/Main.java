package lesson4;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {


        System.out.println("=========== Задание №3 ===========");

        SimpleLinkedListImpl simpleLinkedList = new SimpleLinkedListImpl<>();
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(4);
        simpleLinkedList.insertFirst(5);
        simpleLinkedList.insertFirst(6);

        simpleLinkedList.display();

        System.out.println("remove first: " + simpleLinkedList.removeFirst());

        simpleLinkedList.display();

        simpleLinkedList.remove(5);
        simpleLinkedList.display();

        simpleLinkedList.insert(4, 22);
        simpleLinkedList.display();

        simpleLinkedList.insert(22, 23);
        simpleLinkedList.display();

        simpleLinkedList.insertLast(13);
        simpleLinkedList.display();

        simpleLinkedList.insert(3, 82);
        simpleLinkedList.display();



        System.out.println("=========== Задание №1 ===========");

        Deque<Integer> deque = new LinkedDeque<>();
        System.out.println("add element: " + deque.insert(16));
        System.out.println("add element: " + deque.insert(22));
        System.out.println("add element: " + deque.insert(57));
        System.out.println("add element: " + deque.insert(33));
        System.out.println("add element: " + deque.insert(13));
        System.out.println("add element: " + deque.insert(7));
        deque.display();

        System.out.println("add element to end: " + deque.insertEnd(8887));
        System.out.println("add element to end: " + deque.insertEnd(755));
        deque.display();


        System.out.println("remove element: " + deque.removeEnd());

        //?? непонятно почему элемент удаляется только с двух повторений операции.
        deque.removeEnd();


        deque.display();


        System.out.println("=========== Задание №2 ===========");

        testHomeWork();

    }

    private static void testHomeWork(){

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(12);
        linkedList.insertFirst(36);
        linkedList.insertFirst(48);
        linkedList.insertFirst(2022);


        Iterator<Integer> iterator = linkedList.iterator();

        for (Integer value : linkedList) {
            value = iterator.next();
            System.out.println("value: " + value);
        }
    }
}
