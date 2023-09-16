package search;

import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstFrontier implements Frontier {
    public Queue<Node> queue = new LinkedList<Node>();
    private Integer maxNodes = 0;

    public void add(Node node) {
        queue.add(node);
        maxNodes = Math.max(maxNodes, queue.size());
    }

    public Node remove() {
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }

    public Integer maxNodes() {
        return maxNodes;
    }
}