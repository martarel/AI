package search;

public class AStarFunction implements NodeFunction{
    private NodeFunction heuristic;

    public AStarFunction(NodeFunction heuristic) {
        this.heuristic = heuristic;
    }

    public int value(Node node) {
        return node.cost + heuristic.value(node);
    }
}
