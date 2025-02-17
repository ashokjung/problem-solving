package graph.AdjecencyList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPathDFS {

    public static void main(String[] args)
    {
        ValidPathDFS finder = new ValidPathDFS();
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

    public boolean validPath( int n , int[][] edges, int source, int destination) {

        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, value-> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value-> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited,n);
      
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited , int n) {
        if(source == destination) {
            return true;
        }
        visited[source] = true;
        for(int neighbour: graph.get(source))
        {
            if(!visited[neighbour]) {
                if(dfs(graph, neighbour, destination, visited,n)) {
                    return true;
                }
            }
        }
        return false;
    }
}
