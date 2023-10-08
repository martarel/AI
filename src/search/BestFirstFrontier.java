package search;

import java.util.PriorityQueue;
import java.util.Comparator;

class NodeCostComparator implements Comparator<NodeCost> {
    @Override
    public int compare(NodeCost first, NodeCost second) {
        return Integer.compare(first.getCost(), second.getCost());
    }
}

class NodeCost {
    private Integer cost;
    private Node node;

    public NodeCost(Integer cost, Node node) {
        this.cost = cost;
        this.node = node;
    }

    public Integer getCost() {
        return cost;
    }

    public Node getNode() {
        return node;
    }
}

public class BestFirstFrontier implements Frontier {
    private PriorityQueue<NodeCost> queue = new PriorityQueue<NodeCost>(new NodeCostComparator());
    private NodeFunction f;
    private int maxNodes = 0;


    public BestFirstFrontier(NodeFunction f) {
        this.f = f;
    }

    public void add(Node node) {
        queue.add(new NodeCost(f.value(node), node));
        maxNodes = Math.max(maxNodes, queue.size());
    }

    public Node remove() {
        return queue.poll().getNode();
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

