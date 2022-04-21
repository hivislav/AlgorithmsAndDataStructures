package lesson6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int balance = 0;
        int inBalance = 0;

        ArrayList<Tree> treeList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            for (int j = 0; j < 100; j++) {
                tree.add(randomNumber());
            }
            if (tree.isBalance()) {
                balance++;
            } else {
                inBalance++;
            };
            treeList.add(tree);
        }


        System.out.println("Задание №1. Создать и запустить программу для построения двоичного дерева. \n" +
                "В цикле построить двадцать деревьев с глубиной в 4 уровней. Данные, которыми необходимо заполнить узлы \n" +
                "деревьев, представляются в виде чисел типа int. Число, которое попадает в узел, должно генерироваться \n" +
                "случайным образом в диапазоне от -25 до 25.");

        treeList.get(0).display();
//        treeList.get(1).display();

//        treeList.get(0).isBalance();

        System.out.println("Задание 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.");

        double statisticBalance = (double) balance/20 * 100;
        System.out.println("Сбалансированных деревьев : " + statisticBalance + "%");

    }

    private static int randomNumber () {
        int number;
        int min = -25;
        int max = 25;

        number = (int) (Math.random() * (Math.abs(max) + Math.abs(min) + 1)) - Math.abs(min);
        return number;
    }
}
