package Djikstra;
import java.util.ArrayDeque;

public class Bucket {
    private ArrayDeque<Integer> data;

    public Bucket() {
        this.data = new ArrayDeque<>();
    }

    public void insert(int vertex) {data.offerLast(vertex);}
    public void remove(int vertex) {data.remove(vertex);}
    public int get() {return data.pollFirst();}

    // Проверка на пустоту
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
