import java.util.*;

public class TopSort {
    ArrayList<GraphNode> kahns(final DirectedGraph graph){
        ArrayList<GraphNode> path = new ArrayList<GraphNode>();
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        HashMap<GraphNode, Integer> nodeInDegree = new HashMap<GraphNode, Integer>();


        for(GraphNode node: graph.vertices){
            nodeInDegree.put(node, 0);
        }

        for(GraphNode node: graph.vertices){
            for(GraphNode neighbor: node.neighbors){
                int newIn = nodeInDegree.get(neighbor) + 1;
                nodeInDegree.replace(neighbor, newIn);
            }
        }

        addZerosToQueue(nodeInDegree, queue);

        while(!queue.isEmpty()) {
            GraphNode node = queue.poll();
            path.add(node);

            for(GraphNode neighbor: node.neighbors){
                int newIn = nodeInDegree.get(neighbor) - 1;
                nodeInDegree.replace(neighbor, newIn);
            }
            addZerosToQueue(nodeInDegree, queue);
        }

        return path;
    }

    void addZerosToQueue(HashMap<GraphNode, Integer> nodeInDegree, Queue<GraphNode> queue){
        for(GraphNode node: nodeInDegree.keySet()){
            if(nodeInDegree.get(node) == 0){
                queue.add(node);
                nodeInDegree.replace(node, nodeInDegree.get(node)-1);
            }
        }
    }

    ArrayList<GraphNode> mDFS(final DirectedGraph graph){
        ArrayList<GraphNode> path = new ArrayList<GraphNode>();
        Stack<GraphNode> stack = new Stack<GraphNode>();

        for(GraphNode node: graph.vertices){
            if(!node.getVisited()){
                mDFSUtil(node, stack);
            }
        }

        while(!stack.isEmpty()){
            path.add(stack.pop());
        }

        return path;
    }

    void mDFSUtil(GraphNode node, Stack<GraphNode> stack){
        node.setVisited();
        for(GraphNode neighbor: node.neighbors){
            if(!neighbor.getVisited()){
                mDFSUtil(neighbor, stack);
            }
        }
        stack.push(node);
    }
}
