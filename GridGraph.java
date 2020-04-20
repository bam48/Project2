import java.util.*;
class GridNode {
    public int x;
    public int y;
    public String data;
    public HashSet<GridNode> neighbors;
    public HashSet<GridNode> edges;
    private boolean visited;

    public GridNode(int x, int y, String data) {
        this.x = x;
        this.y = y;
        this.data = data;
        this.neighbors = new HashSet<GridNode>();
        this.edges = new HashSet<GridNode>();
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
public class GridGraph {
    public ArrayList<GridNode> vertices;
    public GridGraph() {
        this.vertices = new ArrayList<>();
    }

    void addGridNode(final int x, final int y, final String nodeVal){
        GridNode gridNode = new GridNode(x, y, nodeVal);
        for(GridNode node: vertices){
            if(node.x == x && node.y == y){
                return;
            }
        }
        vertices.add(gridNode);
        for(GridNode node: vertices){
            int xDif = Math.abs(node.x - x);
            int yDif = Math.abs(node.y - y);

            if(xDif <= 1 && yDif <= 1 && (node.x == x || node.y == y)){
                node.neighbors.add(gridNode);
                gridNode.neighbors.add(node);
            }
        }

    }

    void addUndirectedEdge(final GridNode first, final GridNode second){

        if(first.neighbors.contains(second) && second.neighbors.contains(first)){
            first.edges.add(second);
            second.edges.add(first);
        }

    }

    void removeUndirectedEdge(final GridNode first, final GridNode second){
        first.edges.remove(second);
        second.edges.remove(first);
    }

    HashSet<GridNode> getAllNodes(){
        HashSet<GridNode> allNodes = new HashSet<GridNode>(vertices);
        return allNodes;
    }

}
