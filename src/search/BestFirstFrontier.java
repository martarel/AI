package search;

import java.util.PriorityQueue;
import java.util.Comparator;

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.cost, node2.cost);
    }
}

public class BestFirstFrontier implements Frontier {
    private PriorityQueue<Node> queue = new PriorityQueue<Node>(new NodeComparator());
    private NodeFunction f;
    private int maxNodes = 0;

    public BestFirstFrontier(NodeFunction f) {
        this.f = f;
    }

    public void add(Node node) {
        node.cost = f.value(node);
        System.out.println(node.cost);
        queue.add(node);
        maxNodes = Math.max(maxNodes, queue.size());
    }

    public Node remove() {
        return queue.poll();
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

