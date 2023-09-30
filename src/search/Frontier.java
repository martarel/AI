package search;

public interface Frontier {
    public void add(Node node);
    public Node remove();
    public boolean isEmpty();
    public void clear();
    public int maxNodes();
}