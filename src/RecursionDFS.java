import java.util.HashSet;

public class RecursionDFS {
    private static Graph entity;
    private static HashSet<Integer> visited;

    public static void start(Graph graph, Integer index){
        entity = graph;
        visited = new HashSet<Integer>();
        DFS(index);
    }
    private static void DFS(Integer index){
        if(!visited.contains(index)){
            visited.add(index);
            System.out.println("Recursion Visited index " + index);
            for(var x : entity.data.get(index)){
                DFS(x);
            }
        }
    }

}
