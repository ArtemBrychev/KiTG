package Djikstra;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;


public class GraphWeighted {
    private HashMap<Integer, ArrayList<Edge>> adjList = new HashMap<>();

    // Вложенный класс для представления ребра графа
    public static class Edge {
        int u, v, weight;
        public int getNeighbor(int vertex) {return vertex == u ? v : u;}

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;}

    }

    // Добавление ребра в граф
    public void addEdge(int u, int v, int weight) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(new Edge(u, v, weight));
        adjList.get(v).add(new Edge(v, u, weight));  // Граф неориентированный
    }

    // Получение всех соседей вершины
    public ArrayList<Edge> neighbors(int u) {
        return adjList.getOrDefault(u, new ArrayList<>());
    }

    // Получение всех вершин
    public Set<Integer> getVertices() {return adjList.keySet();}
}
