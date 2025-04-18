package meta;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
class Node{
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node){
        if(node == null) 
        {
            return node;
        }

        if(visited.containsKey(node)) 
        {
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        visited.put(node, cloneNode);
        for(Node neighbor : node.neighbors) 
        {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        // Create a sample graph
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph solution = new CloneGraph();
        Node clonedGraph = solution.cloneGraph(node1);

        // Print the cloned graph's structure
        System.out.println("Cloned Node Value: " + clonedGraph.val);
        System.out.println("Cloned Node Neighbors: ");
        for (Node neighbor : clonedGraph.neighbors) {
            System.out.println("Neighbor Value: " + neighbor.val);
        }
    }
}
