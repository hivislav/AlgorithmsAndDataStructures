package lesson3;

public class Search {

    public static int search (Integer[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int base;
        int lostNum = 0;
        int x = 0;
        int y = 1;

        //проверка на соответствие первого элемента массива (единицы)
        if (arr.length == 0 || arr[start] != 1) {
            System.out.println("Пропущенное число: 1");
        } else {

            try {
                while (true) {
                    if (arr[y] - arr[x] == 2) {
                        lostNum = arr[x];
                        break;
                    }
                    else {
                        y++;
                        x++;
                    }
                }

                //единственный вариант, при котором выходим за границы массива это если пропущенный элемент является последним
            } catch (Exception e) {
                System.out.println("Пропущенное число: " + (arr[end] + 1));
            }

            while (end >= start) {
                base = (start + end) / 2;
                if (arr[base] == lostNum) {
                    System.out.println("Пропущенное число: " + (arr[lostNum] - 1));
                    return base;
                } else if (arr[base] < lostNum) {
                    start = base + 1;
                } else {
                    end = base - 1;
                }
            }
        }
        return -1;
    }
}
