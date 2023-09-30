package search;

import java.util.Set;
import java.util.HashSet;


public class GraphSearch implements Search {
    private Frontier frontier;
    private int nodesExpanded = 0;

    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    public Node findSolution(Node rootNode, GoalTest goalTest) {
        frontier.clear();
        nodesExpanded = 1;
        frontier.add(rootNode);
        Set<State> visited = new HashSet<>();
        visited.add(rootNode.state);
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (goalTest.isGoal(node.state)) {
                return node;
            } else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    if (!visited.contains(newState)) {
                        nodesExpanded++;
                        visited.add(newState);
                        frontier.add(new Node(node, action, newState));
                    }
                }
            }
        }
        return null;
    }

    public int numberOfNodesExpanded() {
        return nodesExpanded;
    }
}