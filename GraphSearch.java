import java.util.*;

public class GraphSearch {
    ArrayList<GraphNode> DFSRec(final GraphNode start, final GraphNode end){
        ArrayList<GraphNode> path = new ArrayList<GraphNode>();

        if(start == null | end == null)
            return null;

        if(start == end) {
            path.add(start);
            return path;
        }

        path.add(start);
        start.setVisited();
        path = DFSRecUtil(start, end, path);

        if(path.isEmpty())
            return null;

        return  path;
    }

    private ArrayList<GraphNode> DFSRecUtil(GraphNode start, GraphNode end, ArrayList<GraphNode> path) {

        for(GraphNode node: start.neighbors){
            if(!node.getVisited()) {
                path.add(node);
                node.setVisited();

                if (node == end) {
                    return path;
                }
                DFSRecUtil(node, end, path);
            }
        }

        if(path.get(path.size() - 1) != end) {
            path.remove(path.size() - 1);
        }

        return path;
    }

    ArrayList<GraphNode> DFSIter(final GraphNode start, final GraphNode end) {
        ArrayList<GraphNode> path = new ArrayList<GraphNode>();

        if(start == null | end == null)
            return null;

        if(start == end) {
            path.add(start);
            return path;
        }

        path.add(start);
        start.setVisited();
        path = DFSIterUtil(start, end, path);

        if(path.isEmpty())
            return null;

        if(path.get(path.size() - 1) != end)
            return null;

        return  path;
    }

    private ArrayList<GraphNode> DFSIterUtil(GraphNode start, GraphNode end, ArrayList<GraphNode> path) {
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.push(start);
        while(!stack.isEmpty()) {
            GraphNode curr = stack.peek();
            if(curr.neighbors.size() == 0) {
                stack.pop();
                if(curr != end){
                    path.remove(curr);
                }
            }

            int i;
            for (i = 0; i < curr.neighbors.size(); i++) {
                if(i == curr.neighbors.size() - 1)
                    stack.pop();

                GraphNode node = curr.neighbors.get(i);
                if (!node.getVisited()) {
                    stack.push(node);
                    path.add(node);
                    node.setVisited();
                    if (node == end) {
                        return path;
                    }
                    break;
                }
            }

        }
        return path;
    }

    ArrayList<GraphNode> BFTRec(final Graph graph){
        ArrayList<GraphNode> path = new ArrayList<GraphNode>();
        Queue<GraphNode> queue = new LinkedList<GraphNode>();

        for(int i = 0; i < graph.vertices.size(); i++){
            GraphNode node = graph.vertices.get(i);
            if(!node.getVisited()){
                node.setVisited();
                queue.add(node);
                path = BFTRecUtil(graph, path, queue);
            }
        }

        if(path.isEmpty())
            return null;

        return path;
    }

    private ArrayList<GraphNode> BFTRecUtil(Graph graph, ArrayList<GraphNode> path, Queue<GraphNode> queue) {
        if(queue.isEmpty())
            return path;

        path.add(queue.poll());

        for(GraphNode curr: graph.vertices){
            if(!curr.getVisited()){
                curr.setVisited();
                queue.add(curr);
            }
        }
        path = BFTRecUtil(graph, path, queue);

        return path;
    }

    ArrayList<GraphNode> BFTIter(final Graph graph){
        ArrayList<GraphNode> path = new ArrayList<GraphNode>();

        for(int i = 0; i < graph.vertices.size(); i++){
            GraphNode node = graph.vertices.get(i);
            if(!node.getVisited()){
                node.setVisited();
                path = BFTIterUtil(graph, path, node);
            }
        }

        if(path.isEmpty())
            return null;

        return path;
    }

    private ArrayList<GraphNode> BFTIterUtil(Graph graph, ArrayList<GraphNode> path, GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);

        while(!queue.isEmpty()){
            GraphNode p = queue.poll();
            path.add(p);
            //System.out.print(p.data + " ");

            for(int i = 0; i < graph.vertices.size(); i++){
                GraphNode curr = graph.vertices.get(i);
                if(!curr.getVisited()){
                    curr.setVisited();
                    queue.add(curr);
                }
            }
        }

        return path;
    }

    void printPath(ArrayList<GraphNode> path){
        System.out.print("Path: ");
        if(path != null) {
            Iterator<GraphNode> i = path.iterator();
            while (i.hasNext())
                System.out.print(i.next().data + " ");
            System.out.println();
        }
    }
}
