import java.util.*;

class WGraphNode {
    public String data;
    public HashMap<WGraphNode, Integer> neighbors;
    private boolean visited;

    public WGraphNode(String data) {
        this.data = data;
        this.neighbors = new HashMap<WGraphNode, Integer>();
        this.visited = false;
    }

    public void setVisited() {
        visited = true;
    }

    public void setUnVisited() {
        visited = false;
    }

    public boolean getVisited() {
        return visited;
    }

}

public class WeightedGraph {
    public ArrayList<WGraphNode> vertices;
    public WeightedGraph() {
        this.vertices = new ArrayList<>();
    }

    void addNode(final String nodeVal){
        WGraphNode newNode = new WGraphNode(nodeVal);
        vertices.add(newNode);
    }

    void addWeightedEdge(final WGraphNode first, final WGraphNode second, final int edgeWeight){
        if(!first.neighbors.containsKey(second)){
            first.neighbors.put(second, edgeWeight);
        }
    }

    void removeDirectedEdge(final WGraphNode first, final WGraphNode second){
        first.neighbors.remove(second);
    }

    HashSet<WGraphNode> getAllNodes(){
        HashSet<WGraphNode> allNodes = new HashSet<WGraphNode>(vertices);
        return allNodes;
    }
}
