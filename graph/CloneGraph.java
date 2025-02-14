package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public static void main(String[] args) {
        // Create a sample graph to test the cloneGraph method
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        

        CloneGraph cg = new CloneGraph();
        Node clonedGraph = cg.cloneGraph(node1);

        // Print the cloned graph to verify
        printGraph(clonedGraph);
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        oldToNew.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei : cur.neighbors) {
                if (!oldToNew.containsKey(nei)) {
                    oldToNew.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }
        return oldToNew.get(node);
    }

    private static void printGraph(Node node) {
        if (node == null) return;
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.put(node, true);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print("Node " + cur.val + " neighbors: ");
            for (Node nei : cur.neighbors) {
                System.out.print(nei.val + " ");
                if (!visited.containsKey(nei)) {
                    visited.put(nei, true);
                    q.add(nei);
                }
            }
            System.out.println();
        }
    }
}