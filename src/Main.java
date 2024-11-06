import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.add(1, new ArrayList<>(List.of(2, 8)));
        graph.add(2, new ArrayList<>(List.of(1, 8, 3)));
        graph.add(3, new ArrayList<>(List.of(2, 8, 4)));
        graph.add(4, new ArrayList<>(List.of(3, 7, 9)));
        graph.add(5, new ArrayList<>(List.of(7, 6)));
        graph.add(6, new ArrayList<>(List.of(5)));
        graph.add(7, new ArrayList<>(List.of(5, 8, 4)));
        graph.add(8, new ArrayList<>(List.of(2, 3, 7, 1)));
        graph.add(9, new ArrayList<>(List.of(4)));

        StackDFS.DFS(graph, 8);
        RecursionDFS.start(graph, 8);

        System.out.println("\n New graph here");
        Graph graph2 = new Graph();
        graph2.add(1, new ArrayList<>(List.of(2, 3, 4, 5)));
        graph2.add(2, new ArrayList<>(List.of(1, 4, 5)));
        graph2.add(3, new ArrayList<>(List.of(1, 6, 7)));
        graph2.add(4, new ArrayList<>(List.of(1, 2, 5)));
        graph2.add(5, new ArrayList<>(List.of(1, 2, 4)));
        graph2.add(6, new ArrayList<>(List.of(3, 7)));
        graph2.add(7, new ArrayList<>(List.of(3, 6)));

        StackDFS.DFS(graph2, 1);
        RecursionDFS.start(graph2, 1);

        System.out.println("Connectivity search");
        Graph graph3 = new Graph();
        graph3.add(0, new ArrayList<>(List.of(2)));
        graph3.add(1, new ArrayList<>(List.of(4)));
        graph3.add(2, new ArrayList<>(List.of(0, 3, 5)));
        graph3.add(3, new ArrayList<>(List.of(2)));
        graph3.add(4, new ArrayList<>(List.of(1)));
        graph3.add(5, new ArrayList<>(List.of(2)));
        ConnectivityComp.ConnectivitySearch(graph3);
    }
}