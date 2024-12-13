package DFS;

import java.util.HashMap;
import java.util.ArrayList;

public class Graph {
    public HashMap<Integer, ArrayList<Integer>> data;
    public Graph(){
        data = new HashMap<>();
    }
    public void add(Integer nodeId, ArrayList<Integer> connections){
        data.put(nodeId, connections);
    }
}
