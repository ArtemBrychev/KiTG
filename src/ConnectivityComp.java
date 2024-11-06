import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;

public class ConnectivityComp {
    private static HashSet<Integer> visited;
    private static Graph graph;

    public static ArrayList<Integer> DFS(Integer beginPoint){
        ArrayList<Integer> num = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        stack.push(beginPoint);
        while(!stack.isEmpty()){
            Integer index = stack.pop();
            if(!visited.contains(index)){
                num.add(index);
                for(var x : graph.data.get(index)){
                    stack.push(x);
                }
                visited.add(index);
            }
        }
        return num;
    }

    public static void ConnectivitySearch(Graph enterGraph){
        visited = new HashSet<Integer>();
        graph = enterGraph;
        ArrayList<ArrayList<Integer>> connectivity = new ArrayList<>();
        for(Integer x : graph.data.keySet()){
            if(!visited.contains(x)){
                connectivity.add(DFS(x));
            }
        }

        for(int i = 0; i < connectivity.size(); i++){
            System.out.print("{");
            for(int j = 0; j < connectivity.get(i).size(); j++){
                System.out.print(connectivity.get(i).get(j));
                if(j<connectivity.get(i).size()-1){
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }
}
