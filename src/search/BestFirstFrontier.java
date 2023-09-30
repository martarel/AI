package search;

import java.util.PriorityQueue;


public class BestFirstFrontier implements Frontier {
    public PriorityQueue<Node> queue = new PriorityQueue<Node>();
    private NodeFunction f;
    private int maxNodes = 0;

    public BestFirstFrontier(NodeFunction f) {
        this.f = f;
    }

    public void add(Node node) {
        node.cost = f.value(node);
        queue.add(node);
        maxNodes = Math.max(maxNodes, queue.size());
    }

    public Node remove() {
        return queue.pop();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
        maxNodes = 0;
    }

    public int maxNodes() {
        return maxNodes;
    }
}

