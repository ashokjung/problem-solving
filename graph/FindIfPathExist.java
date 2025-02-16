package graph;
import java.util.Arrays;

/*
 * Given an undirected graph, determine if there is a path between two nodes.
 * This solution uses Depth First Search to find the path between two nodes.
 * using Adjecency Matrix.
 */

public class FindIfPathExist {

    public static void main(String[] args) {
        FindIfPathExist finder = new FindIfPathExist();
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
        boolean[] visited = new boolean[n];
      return  dfs(graph, source, destination,visited,n);
    }

    private boolean dfs(boolean[][] graph, int source, int destination,boolean[] visited, int n) {
        if(source == destination) {
            return true;
        }
        visited[source] = true;
        for(int i = 0; i < n; i++) {
           
            if(graph[source][i] && !visited[i]) {
               if( dfs(graph, i, destination, visited, n)) {
                   return true;
                }
            }
        }
        return false;
    }
}