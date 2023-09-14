package search;

import java.util.Qeue;

public class BreadthFirstFrontier implements Frontier {
    public Queue<Node> queue = new Queue<Node>();

    public void add(Node node) {
        queue.add(node);
    }

    public void remove(Node node) {
        queue.remove(node);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean contains(Node node) {
        return queue.contains(node);
    }

    public void clear() {
        queue.clear();
    }
}