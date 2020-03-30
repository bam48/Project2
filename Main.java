import java.util.*;
public class Main {
    public static void main(String[] args) {

        GraphNode a = new GraphNode("A");
        GraphNode b = new GraphNode("B");
        GraphNode c = new GraphNode("C");
        GraphNode d = new GraphNode("D");
        GraphNode e = new GraphNode("E");
        GraphNode f = new GraphNode("F");
        GraphNode g = new GraphNode("G");

        a.neighbors = new ArrayList<>(List.of(b, c));
        b.neighbors = new ArrayList<>(List.of(a, d, e));
        c.neighbors = new ArrayList<>(List.of(a, f));
        d.neighbors = new ArrayList<>(List.of(b));
        e.neighbors = new ArrayList<>(List.of(b));
        f.neighbors = new ArrayList<>(List.of(c));

        Graph graph =  new Graph();
        GraphSearch search = new GraphSearch();
        graph.vertices = new ArrayList<>(List.of(a,b,c,d,e,f));
        graph.printAllNodes();
        System.out.println();

        ArrayList<GraphNode> dfsRec = search.DFSRec(e, c);
        System.out.println("DFSRec From E to C");
        printPath(dfsRec);

        graph.unVistAllNodes();
        ArrayList<GraphNode> dfsIter = search.DFSIter(e, c);
        System.out.println("DFSIter From E to C");
        printPath(dfsIter);

        graph.unVistAllNodes();
        ArrayList<GraphNode> dfsIterNoPath = search.DFSIter(e, g);
        System.out.println("DFSIter From E to G. No Path");
        printPath(dfsIterNoPath);

        graph.unVistAllNodes();
        ArrayList<GraphNode> bftRec = search.BFTRec(graph);
        System.out.println("BFTRec ");
        printPath(bftRec);

        graph.unVistAllNodes();
        ArrayList<GraphNode> bftIter = search.BFTIter(graph);
        System.out.println("BFtIter ");
        printPath(bftIter);
        System.out.println();

        graph.addNode("I");
        System.out.println("Add GraphNode with data I to graph:");
        graph.printAllNodes();
        System.out.println();

        graph.addUndirectedEdge(b,f);
        System.out.println("Add Undirected edges between GraphNodes b and f: ");
        System.out.print("b's neighbors:");
        graph.vertices.get(1).printNeighbors();
        System.out.print("f's neighbors:");
        graph.vertices.get(5).printNeighbors();
        System.out.println();

        graph.removeUndirectedEdge(b,f);
        System.out.println("Remove Undirected edges between GraphNodes b and f: ");
        graph.vertices.get(1).printNeighbors();
        System.out.print("f's neighbors:");
        graph.vertices.get(5).printNeighbors();
        System.out.println();

        System.out.println("Random Unweighted Graph ");
        Graph graph1 = createRandomUnweightedGraphIter(5);
        graph1.printAllNodes();
        for (GraphNode node: graph1.vertices) {
            node.printNeighbors();
        }
        System.out.println();

        System.out.println("Graph as Linked List. Middle node has two neighbors. Others have one");
        Graph graph2 = createLinkedList(3);
        graph2.printAllNodes();
        for(int i = 0; i < graph2.vertices.size(); i++){
            graph2.vertices.get(i).printNeighbors();
        }
        System.out.println();

        System.out.println("Recursive BST on Linked List of 100. StackOverflow on 10000");

        Graph graph3 = createLinkedList(100);
        ArrayList<GraphNode> bftRecLL = BFTRecLinkedList(graph3);
        printPath(bftRecLL);
        System.out.println();

        System.out.println("Iterative BST on Linked List of 10000. No StackOverflow");
        Graph graph4 = createLinkedList(10000);
        ArrayList<GraphNode> bftIterLL = BFTIterLinkedList(graph4);
        printPath(bftIterLL);
        System.out.println();


    }

    static Graph createRandomUnweightedGraphIter(int n){
        Graph graph = new Graph();
        Random random = new Random();

        for(int i = 0; i < n; i++){
            char a = (char) (random.nextInt(26) + 'A');
            char b = (char) (random.nextInt(26) + 'A');
            String s = String.valueOf(a) + String.valueOf(b);
            graph.addNode(s);
        }

        int num = graph.vertices.size();
        for (GraphNode node: graph.vertices) {
            int secondNodeIndex = random.nextInt(num);
            GraphNode secondNode = graph.vertices.get(secondNodeIndex);
            graph.addUndirectedEdge(node, secondNode);
        }

        return graph;
    }

    static Graph createLinkedList(int n){
        Graph graph = new Graph();
        Random random = new Random();

        for(int i = 0; i < n; i++){
            char a = (char) (random.nextInt(26) + 'A');
            char b = (char) (random.nextInt(26) + 'A');
            String s = String.valueOf(a) + String.valueOf(b);
            graph.addNode(s);

            if(i == 0)
                continue;

            GraphNode first = graph.vertices.get(i - 1);
            GraphNode second = graph.vertices.get(i);
            graph.addUndirectedEdge(first, second);
        }

        return graph;
    }

    static ArrayList<GraphNode> BFTRecLinkedList(Graph graph){
        GraphSearch search = new GraphSearch();
        return search.BFTRec(graph);
    }

    static ArrayList<GraphNode> BFTIterLinkedList(Graph graph){
        GraphSearch search = new GraphSearch();
        return search.BFTIter(graph);
    }

    static void printPath(ArrayList<GraphNode> path){
        if(path != null) {
            Iterator<GraphNode> i = path.iterator();
            while (i.hasNext())
                System.out.print(i.next().data + " ");
            System.out.println();
        }
    }

}
