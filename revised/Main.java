import java.util.*;
public class Main {
    public static void main(String[] args) {

        System.out.println("Traverse Town");
        System.out.println();
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
        graph.vertices = new ArrayList<>(List.of(a,b,c,d,e,f,g));
        graph.printAllNodes();

        System.out.println("     A");
        System.out.println("   B   C");
        System.out.println(" D  E  F");
        System.out.println("                          G");
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
        System.out.println();
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

        System.out.println("Recursive BST on Linked List of 100. No StackOverflow");
        Graph graph3 = createLinkedList(100);
        ArrayList<GraphNode> bftRecLL = BFTRecLinkedList(graph3);

        System.out.println("Iterative BST on Linked List of 10000. No StackOverflow");
        Graph graph4 = createLinkedList(10000);
        ArrayList<GraphNode> bftIterLL = BFTIterLinkedList(graph4);

        System.out.println("Recursive BST on Linked List of 10000. StackOverflow");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();

        System.out.println("Thank U, Vertext ");
        System.out.println();
        GraphNode aa = new GraphNode("A");
        GraphNode bb = new GraphNode("B");
        GraphNode cc = new GraphNode("C");
        GraphNode dd = new GraphNode("D");
        GraphNode ee = new GraphNode("E");
        GraphNode ff = new GraphNode("F");
        GraphNode gg = new GraphNode("G");
        GraphNode hh = new GraphNode("H");

        aa.neighbors = new ArrayList<>(List.of(bb, dd));
        cc.neighbors = new ArrayList<>(List.of (dd, gg, ff));
        dd.neighbors = new ArrayList<>(List.of(gg));
        hh.neighbors = new ArrayList<>(List.of(ee, ff));

        Graph graph6 =  new Graph();
        graph6.vertices = new ArrayList<>(List.of(aa,bb,cc,dd,ee,ff,gg,hh));
        graph6.printAllNodes();
        TopSort tp = new TopSort();
        DirectedGraph dg = new DirectedGraph();

        GraphNode aaa = new GraphNode("A");
        GraphNode bbb = new GraphNode("B");
        GraphNode ccc = new GraphNode("C");
        GraphNode ddd = new GraphNode("D");
        GraphNode eee = new GraphNode("E");
        GraphNode fff = new GraphNode("F");
        GraphNode ggg = new GraphNode("G");
        GraphNode hhh = new GraphNode("H");

        aaa.neighbors = new ArrayList<>(List.of(bbb, ddd));
        ccc.neighbors = new ArrayList<>(List.of (ddd, ggg, fff));
        ddd.neighbors = new ArrayList<>(List.of(ggg));
        hhh.neighbors = new ArrayList<>(List.of(eee, fff));

        dg.addNode(aaa);
        dg.addNode(bbb);
        dg.addNode(ccc);
        dg.addNode(ddd);
        dg.addNode(eee);
        dg.addNode(fff);
        dg.addNode(ggg);
        dg.addNode(hhh);

        ArrayList<GraphNode> kahnsPath  = tp.kahns(dg);
        ArrayList<GraphNode> mDFSPath  = tp.mDFS(dg);
        System.out.println("kahns");
        printPath(kahnsPath);
        System.out.println("mDFS");
        printPath(mDFSPath);

        System.out.println("kahns 10000");
        tp.kahns(createRandomDAGIter(1000));
        System.out.println("mDFS 10000");
        tp.mDFS(createRandomDAGIter(1000));

        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();


        System.out.println("I Node You Want Me");
        System.out.println("Weighted graphs use WGraphNode instead of normal graph nodes");
        WGraphNode dA = new WGraphNode("A");
        WGraphNode dB = new WGraphNode("B");
        WGraphNode dC = new WGraphNode("C");
        WGraphNode dD = new WGraphNode("D");
        WGraphNode dE = new WGraphNode("E");

        WeightedGraph wGraph = new WeightedGraph();
        wGraph.vertices = new ArrayList<>(List.of(dA,dB,dC,dD,dE));
        wGraph.addWeightedEdge(dA, dB, 3);
        wGraph.addWeightedEdge(dA, dD, 5);
        wGraph.addWeightedEdge(dB, dD, 1);
        wGraph.addWeightedEdge(dD, dE, 2);
        wGraph.addWeightedEdge(dB, dC, 2);
        wGraph.addWeightedEdge(dB, dE, 6);
        wGraph.addWeightedEdge(dE, dC, 1);
        System.out.println("Dots represent arrows for direction. Sorry for the terrible graph");
        System.out.println("         A");
        System.out.println("        / \\");
        System.out.println("      .     .");
        System.out.println("     3       5");
        System.out.println("    B  --. 1  D");
        System.out.println("  /  \\      /");
        System.out.println(" .    .    .");
        System.out.println("2     6    2");
        System.out.println("C        E");
        System.out.println();

        HashMap<WGraphNode, Integer> minVal = dijkstras(dA);
        for(WGraphNode node: minVal.keySet()){
            System.out.println(node.data + " " +  minVal.get(node));
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();


        System.out.println("Wish Upon A*");
        GridGraph gGraph = createRandomGridGraph(100);
        GridNode sourceNode = gGraph.vertices.get(0);
        GridNode destNode = gGraph.vertices.get(gGraph.vertices.size()-1);
    }



    public static GridGraph createRandomGridGraph(int n){
        GridGraph gg = new GridGraph();
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                String xy = String.valueOf("(" + x + ", " + y + ")");
                gg.addGridNode(x, y, xy);
            }
        }

        for(GridNode node: gg.getAllNodes()){
            for(GridNode neighbor: node.neighbors){
                if(Math.random() < 0.3){
                    gg.addUndirectedEdge(node, neighbor);
                }
            }
        }

        return gg;
    }

    static HashMap<WGraphNode, Integer> dijkstras(final WGraphNode start){
        HashMap<WGraphNode, Integer> minValues = new  HashMap<WGraphNode, Integer>();
        Queue<DNode> queue = new LinkedList<DNode>();
        DNode dNode = new DNode(start, 0);

        while(dNode != null){
            minValues.put(dNode.dNode, dNode.cost);
            HashMap<WGraphNode, Integer> neighbors = dNode.dNode.neighbors;

            for (WGraphNode neighbor : neighbors.keySet()){
                Integer sumCost = dNode.cost + neighbors.get(neighbor);
                Integer prevCost;
                if(minValues.containsKey(neighbor)){
                    prevCost = minValues.get(neighbor);
                }
                else{
                    prevCost = Integer.MAX_VALUE;
                }

                if(sumCost < prevCost){
                    DNode dNeighbor = new DNode(neighbor, sumCost);
                    queue.add(dNeighbor);
                    minValues.put(neighbor, sumCost);
                }
            }
            dNode = queue.poll();
        }
        return minValues;
    }

    static class DNode{
        WGraphNode dNode;
        Integer cost;

        public DNode(WGraphNode dNode, Integer cost){
            this.dNode = dNode;
            this.cost = cost;
        }
    }

    static WeightedGraph createRandomCompleteWeightedGraph(final int n){
        WeightedGraph wg = new WeightedGraph();
        Random random = new Random();

        for(int i = 0; i < n; i++){
            char a = (char) (random.nextInt(26) + 'A');
            char b = (char) (random.nextInt(26) + 'A');
            String s = String.valueOf(a) + String.valueOf(b);
            wg.addNode(s);
        }

        for(WGraphNode node: wg.getAllNodes()){
            for(WGraphNode secondNode: wg.getAllNodes()){
                if(node != secondNode){
                    int edgeWeight = random.nextInt(20);
                    wg.addWeightedEdge(node, secondNode, edgeWeight);
                }
            }
        }

        return wg;

    }

    //Name changed from createLinkedList to createLinkedListW due to duplicate from previous problem
    static WeightedGraph createLinkedListW(final int n){
        WeightedGraph wg = new WeightedGraph();
        Random random = new Random();

        for(int i = 0; i < n; i++){
            char a = (char) (random.nextInt(26) + 'A');
            char b = (char) (random.nextInt(26) + 'A');
            String s = String.valueOf(a) + String.valueOf(b);
            wg.addNode(s);

            if(i == 0)
                continue;

            WGraphNode first = wg.vertices.get(i - 1);
            WGraphNode second = wg.vertices.get(i);
            wg.addWeightedEdge(first, second, 1);
        }

        return wg;
    }

    static DirectedGraph createRandomDAGIter(final int n){
        DirectedGraph dag = new DirectedGraph();
        Random random = new Random();

        for(int i = 0; i < n; i++){
            String s  = String.valueOf(i);
            dag.addNode(s);
        }

        int num = dag.getAllNodes().size();
        for (GraphNode node: dag.getAllNodes()) {
            int secondNodeIndex = random.nextInt(num);
            GraphNode secondNode = (GraphNode) dag.getAllNodes().toArray()[secondNodeIndex];
            dag.addDirectedEdge(node, secondNode);
        }
        return dag;

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


    static class StarNode {
        GridNode gridNode;
        int costSoFar;
        int heuristic;
        int totalCost;


        public StarNode(GridNode starNode, int costSoFar, int heuristic) {
            this.gridNode = starNode;
            this.costSoFar = costSoFar;
            this.heuristic = heuristic;
            this.totalCost = this.costSoFar + this.heuristic;
        }
    }

    private static int getManDist(GridNode start, GridNode end){
        int xDif = Math.abs(start.x - end.x);
        int yDif = Math.abs(start.y - end.y);
        return xDif + yDif;
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
