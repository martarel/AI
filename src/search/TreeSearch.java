package search;

class TreeSearch implements Search {
    private Frontier frontier;
    private Integer nodesExpanded = 0;

    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    public Node findSolution(Node rootNode, GoalTest goalTest) {
        frontier.clear();
        nodesExpanded = 0;
        frontier.add(rootNode);
        while (!frontier.isEmpty()) {
            nodesExpanded++;
            Node node = frontier.remove();
            if (goalTest.isGoal(node.state)) {
                return node;
            } else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    frontier.add(new Node(node, action, newState));
                }
            }
        }
        return null;
    }

    public Integer numberOfNodesExpanded() {
        return nodesExpanded;
    }
}