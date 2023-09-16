package search;

import java.util.Set;
import java.util.HashSet;


class GraphSearch implements Search {
    private Frontier frontier;
    private Integer nodesExpanded = 0;

    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    public Node findSolution(Node rootNode, GoalTest goalTest) {
        frontier.clear();
        nodesExpanded = 0;
        frontier.add(rootNode);
        Set<State> visited = new HashSet<>();
        visited.add(rootNode.state);
        while (!frontier.isEmpty()) {
            nodesExpanded++;
            Node node = frontier.remove();
            if (goalTest.isGoal(node.state)) {
                return node;
            } else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        frontier.add(new Node(node, action, newState));
                    }
                }
            }
        }
        return null;
    }

    public Integer numberOfNodesExpanded() {
        return nodesExpanded;
    }
}