 package graph;
 import java.util.*;

 class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph1 {
private Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }

    public class Main {
        public static void main(String[] args) {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
        
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
            node2.neighbors.add(node3);
            node3.neighbors.add(node2);
        

            CloneGraph1 solution = new CloneGraph1();
            Node clonedGraph = solution.cloneGraph(node1);
    
            System.out.println("Cloned graph starting node: " + clonedGraph.val);
        }
     
}
}