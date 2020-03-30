import java.util.*;

public class Graph {
        public ArrayList<GraphNode> vertices;
        public Graph() {
            this.vertices = new ArrayList<>();
        }

        void addNode(final String nodeVal){

            GraphNode newNode = new GraphNode(nodeVal);
            vertices.add(newNode);
        }

        void addUndirectedEdge(final GraphNode first, final GraphNode second){
            if(!first.neighbors.contains(second))
                first.neighbors.add(second);
            if(!second.neighbors.contains(first))
                second.neighbors.add(first);
        }

        void removeUndirectedEdge(final GraphNode first, final GraphNode second){
            first.neighbors.remove(second);
            second.neighbors.remove(first);
        }

        HashSet<GraphNode> getAllNodes(){
            HashSet<GraphNode> allNodes = new HashSet<GraphNode>(vertices);
            return allNodes;
        }

        //Prints the values of the HashSet from getAllNodes()
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
