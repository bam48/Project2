import java.util.*;

public class DirectedGraph {
    private HashSet<GraphNode> vertices = new HashSet<GraphNode>();

    void addNode(final String nodeVal){
        GraphNode newNode = new GraphNode(nodeVal);
        vertices.add(newNode);
    }
    void addNode(final GraphNode newNode){
        vertices.add(newNode);
    }

    void addDirectedEdge(final GraphNode first, final GraphNode second){
            if(!first.neighbors.contains(second))
                first.neighbors.add(second);
    }

    void removeDirectedEdge(final GraphNode first, final GraphNode second){
            first.neighbors.remove(second);
    }

    HashSet<GraphNode> getAllNodes(){
        return vertices;
    }

    void printAllNodes(){
        System.out.print("All GraphNodes in Graph (Not in order of insertion): ");
        Iterator<GraphNode> i = getAllNodes().iterator();
        while (i.hasNext())
            System.out.print(i.next().data + " ");
        System.out.println();
    }

    //Sets all visited to false for all nodes in a graph
    //Allows multiple searches on one graph
    void unVistAllNodes(){
        for(GraphNode node: getAllNodes()){
            node.setUnVisited();
        }
    }
}
