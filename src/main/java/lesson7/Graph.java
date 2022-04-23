package lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int distance);

    int getSize();

    void display();

    //Depth-first search, DFS - поиск в глубину

    void dfs(String startLabel, String endLabel);

}
