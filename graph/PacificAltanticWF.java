package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAltanticWF {


    public static void main(String[] args){
            int[][] heights = {
                {4,2,7,3,4},
                {7,4,6,4,7},
                {6,3,5,3,6}
            };

            PacificAltanticWF solution = new PacificAltanticWF();
            List<List<Integer>> result = solution.pacificAtlantic(heights);

            for (List<Integer> cell : result) {
                System.out.println(cell);
            }
    }

    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      
         int ROWS = heights.length;
         int COLS = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

         boolean[][] pacific = new boolean[ROWS][COLS];
         boolean[][] atlantic = new boolean[ROWS][COLS];

         for(int c=0; c<COLS ; c++){
            dfs(0, c, pacific, heights);
            dfs(ROWS-1, c, atlantic, heights);
        }
        for(int r = 0; r< ROWS ; r++){
        dfs(r, 0, pacific, heights);
        dfs(r, COLS-1, atlantic, heights);
        }

        for( int r=0 ; r< ROWS ; r++){
            for( int c =0 ; c < COLS ; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }


        return result;
    }

    private  void dfs(int r , int c, boolean[][] ocean , int[][] heights ){

        ocean[r][c]= true;
        for( int[] d: directions){
            int nr = r+d[0] , nc = c+d[1];

            if(nr >=0 && nr < heights.length && 
            nc >=0 && nc < heights[0].length &&
            !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, ocean, heights);
            }
        }

    }

    
}