package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
    public Stack<Node> stack = new Stack<Node>();

    public void add(Node node) {
        stack.add(node);
    }

    public void remove(Node node) {
        stack.remove(node);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean contains(Node node) {
        return stack.contains(node);
    }

    public void clear() {
        stack.clear();
    }
}