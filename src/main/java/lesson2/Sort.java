package lesson2;

import lesson2.NoteBook;

public class Sort {


    public static void sort (NoteBook[] noteBooks) {
        int limit = noteBooks.length;





        // стандартная сортировка пузырьком по трем условиям
        do {
            limit--;
            for (int i = 0; i < limit; i++) {
                if (noteBooks[i].getPrice() > noteBooks[i + 1].getPrice()) {
                    NoteBook temp = noteBooks[i];
                    noteBooks[i] = noteBooks[i + 1];
                    noteBooks[i + 1] = temp;
                }
                else if (noteBooks[i].getPrice() == noteBooks[i + 1].getPrice() &&
                        noteBooks[i].getDdr() > noteBooks[i + 1].getDdr()) {
                    NoteBook temp = noteBooks[i];
                    noteBooks[i] = noteBooks[i + 1];
                    noteBooks[i + 1] = temp;
                }
                else if (noteBooks[i].getDdr() == noteBooks[i + 1].getDdr() &&
                        noteBooks[i].getPriority() > noteBooks[i + 1].getPriority()){
                    NoteBook temp = noteBooks[i];
                    noteBooks[i] = noteBooks[i + 1];
                    noteBooks[i + 1] = temp;
                }
            }
        }
        while (limit > 0) ;
    }
}
