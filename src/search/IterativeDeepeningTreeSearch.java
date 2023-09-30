package search;

public class IterativeDeepeningTreeSearch {
    private DepthFirstFrontier frontier = new DepthFirstFrontier();
    private int nodesExpanded = 0;

    public Node findSolution(Node rootNode, GoalTest goalTest) {
        for (int maxDepth = 1; maxDepth <= 10000; maxDepth++) {
            nodesExpanded = 1;
            frontier.clear();
            frontier.add(new Node(null, null, rootNode.state, 0));
            while (!frontier.isEmpty()) {
                Node node = frontier.remove();
                if (node.depth >= maxDepth) {
                    break;
                }
                if (goalTest.isGoal(node.state)) {
                    return node;
                } else {
                    for (Action action : node.state.getApplicableActions()) {
                        State newState = node.state.getActionResult(action);
                        frontier.add(new Node(node, action, newState, node.depth + 1));
                        nodesExpanded++;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public int numberOfNodesExpanded() {
        return nodesExpanded;
    }

    public int maxNodes() {
        return frontier.maxNodes();
    }
}
