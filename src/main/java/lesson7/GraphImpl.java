package lesson7;

import java.util.*;

public class GraphImpl implements Graph{

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private final boolean[][] visitedMatrix;

    static int tempDistance = 0;
    public static ArrayList<Integer> arrDistance = new ArrayList<>();
    public static HashMap vertexMap = new HashMap<>();

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.visitedMatrix = new boolean[maxVertexCount][maxVertexCount];

    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = distance;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel, int distance) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());


            if (vertex == null) {
                stack.pop();
            } else {
                visitVertex(stack, vertex);
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);



        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !visitedMatrix[currentIndex][i]) {

                System.out.println(vertex.getLabel() + " ==> " + adjMatrix[currentIndex][i] + " км. ");

                tempDistance += adjMatrix[currentIndex][i];
                visitedMatrix[currentIndex][i] = true;
                vertexMap.put(vertexList.get(i).getLabel(), tempDistance);
                dfs(vertexList.get(i).getLabel(), tempDistance);
            }
        }

        if (tempDistance != 0) {
            arrDistance.add(tempDistance);
            System.out.println("Суммарное расстояние: " + tempDistance);
        }
        tempDistance = 0;
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        vertex.setVisited(true);
    }
}