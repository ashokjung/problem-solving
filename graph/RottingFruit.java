package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingFruit {

     public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottingFruit rf = new RottingFruit();
        System.out.println(rf.orangesRotting(grid));
     }
     public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for(int r=0; r< grid.length; r++){
            for(int  c=0; c< grid[0].length;c++){
                if(grid[r][c] == 1) {       
                    fresh++;
                }

                if(grid[r][c]==2){
                    queue.offer(new int[]{r,c});
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(fresh>0 && ! queue.isEmpty()){
            int length = queue.size();
            for( int i =0 ; i< length ;i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                for(int[] dir : directions){
                    int row = r+ dir[0];
                    int col = c + dir[1];
                    if(row >=0 && row < grid.length && 
                        col >= 0 && col < grid[0].length && 
                        grid[row][col] ==1 ){
                            grid[row][col] =2;
                            queue.offer(new int[] {row, col});
                            fresh --;
                        }
                }
            }
            time++;
        }
        return fresh==0 ? time : -1;
    }
}