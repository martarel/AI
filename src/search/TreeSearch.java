package search;

public class TreeSearch implements Search {
    private Frontier frontier;
    private int nodesExpanded = 0;

    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    public Node findSolution(Node rootNode, GoalTest goalTest) {
        frontier.clear();
        nodesExpanded = 1;
        frontier.add(rootNode);
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (goalTest.isGoal(node.state)) {
                return node;
            } else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    nodesExpanded++;
                    frontier.add(new Node(node, action, newState, node.depth + 1, node.cost + action.cost()));
                }
            }
        }
        return null;
    }

    public int numberOfNodesExpanded() {
        return nodesExpanded;
    }
}