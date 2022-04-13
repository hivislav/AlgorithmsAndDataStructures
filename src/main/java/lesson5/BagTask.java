package lesson5;

import java.util.ArrayList;

public class BagTask {
    private static ArrayList<Thing> resultThings = new ArrayList<>();
    private static ArrayList<Thing> tempThings = new ArrayList<>();
    private static int bestPrice;
    private static int maxWeight = 5;

    public static void main(String[] args) {
        System.out.println("Задача №2. Написать программу «Задача о рюкзаке» с помощью рекурсии.");
        System.out.println("=========================");
        ArrayList<Thing> things = new ArrayList<>();
        things.add(new Thing("Ноутбук", 40000, 4));
        things.add(new Thing("Часы", 5000, 1));
        things.add(new Thing("Гиря", 100, 5));
        things.add(new Thing("Гитара", 37000, 3));
        things.add(new Thing("Смартфон", 10000, 2));

        new BagTask().betterBag(things);
        for (Thing thing: resultThings) {
            System.out.println("Имя позиции: " + thing.getName() + " Цена: " + thing.getPrice() +
                    " Вес: " + thing.getWeight());
        }
    }

    private ArrayList<Thing> betterBag(ArrayList<Thing> things) {
        if (things.size() > 0)
            compare(things);
        for (int i = 0; i < things.size(); i++) {
            tempThings = new ArrayList<Thing>(things);
            tempThings.remove(i);
            betterBag(tempThings);
        }
        return resultThings;
    }

    private int allPrice(ArrayList<Thing> things) {
        int sumPrice = 0;
        for (int i = 0; i < things.size(); i++) {
            sumPrice += things.get(i).getPrice();
        }
        return sumPrice;
    }

    private int allWeight(ArrayList<Thing> things) {
        int sumWeight = 0;
        for (int i = 0; i < things.size(); i++) {
            sumWeight += things.get(i).getWeight();
        }
        return sumWeight;
    }

    private void compare (ArrayList<Thing> things) {
        if (resultThings == null) {
            if (allWeight(things) <= maxWeight) {
                resultThings = things;
                bestPrice = allPrice(things);
            }
        } else {
            if (allWeight(things) <= maxWeight && allPrice(things) > bestPrice) {
                resultThings = things;
                bestPrice = allPrice(things);
            }
        }
    }
}
