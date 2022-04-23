package lesson7;

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
        graph.dfs("Москва", "Воронеж");
        System.out.println(GraphImpl.arrDistance.get(0));
        System.out.println(GraphImpl.arrDistance.get(1));
        System.out.println(GraphImpl.arrDistance.get(2));

//        GraphImpl.showResult(GraphImpl.arrDistance);

    }
}
