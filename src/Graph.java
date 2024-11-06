import java.util.HashMap;
import java.util.ArrayList;

public class Graph {
    HashMap<Integer, ArrayList<Integer>> data;
    Graph(){
        data = new HashMap<>();
    }
    public void add(Integer nodeId, ArrayList<Integer> connections){
        data.put(nodeId, connections);
    }
}
