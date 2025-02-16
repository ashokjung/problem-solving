package graph.AdjecencyMatrix;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given an undirected graph, determine if there is a path between two nodes.
 * This solution uses Breadth First Search to find the path between two nodes.
 * using Adjecency Matrix.
 */


public class ValidPathBFS {
    public static void main(String[] args) {
        ValidPathBFS finder = new ValidPathBFS();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0;
        int destination = 5;
        boolean result = finder.validPath(n, edges, source, destination);
        System.out.println("Path exists: " + result);

        int n1 = 3 ;
        int [][] edges1 = {{0,1},{1,2},{2,0}};
        int source1 = 0;
        int destination1 = 2;
        boolean result1 = finder.validPath(n1, edges1, source1, destination1);
        System.out.println("Path exists: " + result1);
    }
    
    public boolean validPath( int n , int[][] egdes, int source, int destination) {
        boolean[][] graph = new boolean[n][n];
        for(boolean[] row : graph) {
            Arrays.fill(row, false);
        }
        for (int[] edge : egdes) {
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = true;
            graph[v][u] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        boolean[] visited = new boolean[n];

        for( int i =0 ; i < n ; i++) {
            visited[i] = false;
        }

        while(!queue.isEmpty()) {
            int current = queue.remove();
            if(current == destination) {
                return true;
            }
            for(int i=0 ;i<n ;i++){
                if(graph[current][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
           
        }
        return false;
    }

    
}