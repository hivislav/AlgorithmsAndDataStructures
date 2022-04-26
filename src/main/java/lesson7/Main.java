package lesson7;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 100);
        graph.addEdge("Москва", "Рязань", 105);
        graph.addEdge("Москва", "Калуга", 90);
        graph.addEdge("Тула", "Липецк", 70);
        graph.addEdge("Рязань", "Тамбов", 65);
        graph.addEdge("Калуга", "Орел", 80);
        graph.addEdge("Липецк", "Воронеж", 150);
        graph.addEdge("Тамбов", "Саратов", 40);
        graph.addEdge("Орел", "Курск", 35);
        graph.addEdge("Саратов", "Воронеж", 60);
        graph.addEdge("Курск", "Воронеж", 70);


        graph.display();
        graph.dfs("Москва", 0);
        showResult(GraphImpl.arrDistance);


        System.out.println(GraphImpl.vertexMap.toString());
    }


    public static void showResult(ArrayList<Integer> arrDistance) {
        int temp;
        int result = 1000000;

        for (int i = 0; i < arrDistance.size(); i++) {
            temp = arrDistance.get(i);
            if (temp < result) {
                result = temp;
            }
        }
        System.out.println("Кратчайшее расстояние: " + result);
    }
}
