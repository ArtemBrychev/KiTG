package Heap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Конструктор для создания кучи с заданной ёмкостью
    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Метод для получения индекса корня (root)
    private int root(int i) {
        return (i - 1) / 2;
    }

    // Метод для получения индекса левого узла (node)
    private int leftNode(int i) {
        return 2 * i + 1;
    }

    // Метод для получения индекса правого узла (node)
    private int rightNode(int i) {
        return 2 * i + 2;
    }

    // Метод для того, чтобы восстановить свойство кучи после добавления нового элемента
    private void heapifyUp(int i) {
        while (i > 0 && heap[root(i)] > heap[i]) {
            // Меняем местами корень и текущий элемент
            int temp = heap[i];
            heap[i] = heap[root(i)];
            heap[root(i)] = temp;
            i = root(i);
        }
    }

    // Метод для того, чтобы восстановить свойство кучи после удаления элемента
    private void heapifyDown(int i) {
        int left = leftNode(i);
        int right = rightNode(i);
        int smallest = i;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            // Меняем местами текущий элемент с наименьшим из узлов
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapifyDown(smallest);
        }
    }

    // Метод для добавления нового элемента в кучу
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap overflow");
            return;
        }

        // Добавляем новый элемент в конец кучи
        heap[size] = key;
        size++;

        // Восстанавливаем свойство кучи
        heapifyUp(size - 1);
    }

    // Метод для удаления минимального элемента из кучи (корень)
    public int deleteMin() {
        if (size <= 0) {
            System.out.println("Heap underflow");
            return Integer.MAX_VALUE;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        // Минимальный элемент — корень, заменяем его последним элементом
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Восстанавливаем свойство кучи
        heapifyDown(0);

        return root;
    }

    // Метод для уменьшения ключа в куче
    public void decreaseKey(int i, int newVal) {
        heap[i] = newVal;

        // Восстанавливаем свойство кучи (путём подъема элемента)
        heapifyUp(i);
    }

    // Метод для увеличения ключа в куче
    public void increaseKey(int i, int newVal) {
        heap[i] = newVal;

        // Восстанавливаем свойство кучи (путём спуска элемента)
        heapifyDown(i);
    }

    // Метод для получения минимального элемента (корня кучи)
    public int getMin() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE;
        }
        return heap[0];
    }

    // Метод для печати элементов кучи
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

