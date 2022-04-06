package lesson3;

public class Main {
    public static void main(String[] args) {
        Integer [] homeworkArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Integer [] homeworkArray1 = {1, 2, 4, 5, 6};
        Integer [] homeworkArray2 = {2, 3, 4, 5, 6, 7, 8};
        Integer [] homeworkArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Integer [] homeworkArray4 = {};


        Search.search(homeworkArray);
        Search.search(homeworkArray1);
        Search.search(homeworkArray2);
        Search.search(homeworkArray3);
        Search.search(homeworkArray4);
    }

}
