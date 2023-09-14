package search;

public interface Frontier {
    public void add(Node node);
    public Node remove();
    public boolean isEmpty();
    public boolean contains(Node node);
    public void clear();
}