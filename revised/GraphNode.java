import java.util.*;

// GraphNode from Repl.it
public class GraphNode {
    public String data;
    public ArrayList<GraphNode> neighbors;
    private boolean visited;

    public GraphNode(String data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
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

    //Prints a GraphNode's Neighbors
    void printNeighbors(){
        System.out.print(data + "'s neighbors: ");
        Iterator<GraphNode> i = neighbors.iterator();
        while (i.hasNext()) {
            System.out.print(i.next().data + " ");
        }
        System.out.println();
    }
}