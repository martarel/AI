package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
    public Stack<Node> stack = new Stack<Node>();
    private int maxNodes = 0;

    public void add(Node node) {
        stack.add(node);
        maxNodes = Math.max(maxNodes, stack.size());
    }

    public Node remove() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {
        stack.clear();
        maxNodes = 0;
    }

    public int maxNodes() {
        return maxNodes;
    }
}