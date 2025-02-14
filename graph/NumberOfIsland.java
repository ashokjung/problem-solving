package graph;

public class NumberOfIsland{

    private static final int[][] directions =  {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args)
    {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println("Number of Islands : " + new NumberOfIsland().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
     int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands =0;

        for(int r = 0; r < ROWS; r++) {
            for (int c=0; c < COLS; c++){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c);
                    islands++;
                }
            } 
        }
       return islands;
    }

     private void dfs(char[][] grid, int r , int c){
        if(r <0 || c <0 || r >= grid.length || c>= grid[0].length || 
        grid[r][c]== '0'){
            return;
        }
        grid[r][c]='0';
        for(int[] dir : directions )
        {
            dfs(grid, r+dir[0], c+ dir[1]);
        }
     }

}