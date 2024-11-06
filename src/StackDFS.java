import java.util.HashSet;
import java.util.Stack;

public class StackDFS {
    public static void DFS(Graph graph, Integer beginPoint){
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        stack.push(beginPoint);
        while(!stack.isEmpty()){
            Integer index = stack.pop();
            if(!visited.contains(index)){
                System.out.println("Stack Visited index: " + index);
                for(var x : graph.data.get(index)){
                    stack.push(x);
                }
                visited.add(index);
            }
        }
    }
}
