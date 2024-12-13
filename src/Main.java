import DFS.*;
import Djikstra.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        //testDFS();
        testDjikstra();
    }

    public static void testDFS(){
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

    public static void testDjikstra(){
        //test 1
        GraphWeighted graph = new GraphWeighted();
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 3);

        // Запускаем алгоритм Дейкстры
        DjikstraAlgorithm dijkstra = new DjikstraAlgorithm(graph);
        HashMap<Integer, Integer> distances = dijkstra.run(0);

        // Выводим результаты
        System.out.println("Test1 Кратчайшие расстояния от 0:");
        for (var entry : distances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Выводим кратчайший путь от 0 до 3
        System.out.println("\n Кратчайший путь от 0 до 3:");
        List<Integer> path = dijkstra.getShortestPath(0, 3);
        System.out.println(path);

        //test2
        GraphWeighted graph2 = new GraphWeighted();
        graph2.addEdge(0, 1, 10);
        graph2.addEdge(1, 2, 20);
        graph2.addEdge(2, 3, 30);
        graph2.addEdge(0, 3, 50);

        DjikstraAlgorithm djikstra2 = new DjikstraAlgorithm(graph2);
        HashMap<Integer, Integer> distances2 = djikstra2.run(0);

        System.out.println("\nTest2 Кратчайшие расстояния от 0:");
        for (HashMap.Entry<Integer, Integer> entry : distances2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nКратчайший путь от 0 до 3:");
        List<Integer> path2 = djikstra2.getShortestPath(0, 3);
        System.out.println(path2);

        //test3
        GraphWeighted graph3 = new GraphWeighted();
        graph3.addEdge(0, 1, 5);
        graph3.addEdge(1, 2, 10);
        graph3.addEdge(2, 3, 2);
        graph3.addEdge(3, 0, 3);  // Цикл

        DjikstraAlgorithm djikstra3 = new DjikstraAlgorithm(graph3);
        HashMap<Integer, Integer> distances3 = djikstra3.run(0);

        System.out.println("\nTest3 Кратчайшие расстояния от 0:");
        for (HashMap.Entry<Integer, Integer> entry : distances3.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nКратчайший путь от 0 до 3:");
        List<Integer> path3 = djikstra3.getShortestPath(0, 3);
        System.out.println(path3);

        testLargeGraphPerformance();
    }

    public static void testLargeGraphPerformance() {
        for(int nodeCount = 1000; nodeCount <= 1000000; nodeCount*=10) {
            GraphWeighted graph = new GraphWeighted();
            Random rand = new Random();
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < 10; j++) { // Каждая вершина соединяется с 10 случайными
                    int neighbor = rand.nextInt(nodeCount);
                    int weight = rand.nextInt(100) + 1; // Вес ребра от 1 до 100
                    graph.addEdge(i, neighbor, weight);
                }
            }

            // Запуск алгоритма
            DjikstraAlgorithm algorithm = new DjikstraAlgorithm(graph);
            long startTime = System.currentTimeMillis();
            HashMap<Integer, Integer> distances = algorithm.run(0); // Старт с вершины 0
            long endTime = System.currentTimeMillis();

            // Проверка времени выполнения
            System.out.println("Nodecount: " + nodeCount + " Time taken for large graph: " + (endTime - startTime) + " ms");
        }
    }

}