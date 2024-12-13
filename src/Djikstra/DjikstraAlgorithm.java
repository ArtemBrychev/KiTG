package Djikstra;
import java.util.*;

public class DjikstraAlgorithm {
    private GraphWeighted graph;
    private HashMap<Integer, Integer> distances;
    private HashMap<Integer, Integer> previous;
    private HashMap<Integer, Bucket> buckets;

    public DjikstraAlgorithm(GraphWeighted graph) {
        this.graph = graph;
        this.distances = new HashMap<>();
        this.previous = new HashMap<>();
        this.buckets = new HashMap<>();
    }

    public HashMap<Integer, Integer> run(int start) {
        for (int vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }
        distances.put(start, 0);

        Bucket initialBucket = new Bucket();
        initialBucket.insert(start);
        buckets.put(0, initialBucket);

        // Основной цикл алгоритма Дейкстры
        while (!buckets.isEmpty()) {
            // Ищем первый непустой черпак
            Integer currentDistance = buckets.keySet().stream().min(Integer::compare).orElse(null);
            if (currentDistance == null) break;  // Если все черпаки пустые, завершаем

            Bucket currentBucket = buckets.get(currentDistance);
            if (currentBucket.isEmpty()) {
                buckets.remove(currentDistance);  // Удаляем пустой черпак
                continue;
            }

            // Извлекаем вершину с минимальным расстоянием
            int currentVertex = currentBucket.get();
            if (distances.get(currentVertex) < currentDistance) continue;

            // Обрабатываем всех соседей вершины
            for (GraphWeighted.Edge edge : graph.neighbors(currentVertex)) {
                int neighbor = edge.getNeighbor(currentVertex);
                int newDist = distances.get(currentVertex) + edge.weight;

                if (newDist < distances.get(neighbor)) {
                    // Обновляем расстояние до соседа
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, currentVertex);

                    // Добавляем соседа в новый черпак с обновленным расстоянием
                    Bucket neighborBucket = buckets.computeIfAbsent(newDist, k -> new Bucket());
                    neighborBucket.insert(neighbor);
                }
            }
        }

        return distances;
    }

    // Получение кратчайшего пути от начальной вершины до целевой
    public List<Integer> getShortestPath(int start, int target) {
        List<Integer> path = new LinkedList<>();
        Integer current = target;
        while (current != null) {path.add(current);
            current = previous.get(current);}
        Collections.reverse(path);  // Переворачиваем путь, чтобы он был от start до target
        return path;
    }
}
