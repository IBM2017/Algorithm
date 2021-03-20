package 岛屿数量;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    Queue<coordinateClass> save1Coor = new PriorityQueue<>();
    Queue<coordinateClass> save0Coor = new PriorityQueue<>();
    boolean[][] judge;
    int nums;
    public int numIslands(char[][] grid) {
        if (grid.length==0||grid[0].length==0) return 0;
        judge = new boolean[grid.length][grid[0].length];
        if (grid[0][0] == '0') save0Coor.add(new coordinateClass(0,0));
        else save1Coor.add(new coordinateClass(0,0));
        judge[0][0]=true;
        boolean change = false;
        while (!(save0Coor.isEmpty()&&save1Coor.isEmpty())){
            change = false;
            while (!save0Coor.isEmpty()){
                coordinateClass center = save0Coor.remove();
                if (judge0And1(grid,center.x+1,center.y)) break;
                if (judge0And1(grid,center.x,center.y+1)) break;
                if (judge0And1(grid,center.x-1,center.y)) break;
                if (judge0And1(grid,center.x,center.y-1)) break;
            }
            while (!save1Coor.isEmpty()){
                change = true;
                coordinateClass center = save1Coor.remove();
                judge0And1(grid,center.x,center.y);
                judge0And1(grid,center.x+1,center.y+1);
                judge0And1(grid,center.x-1,center.y);
                judge0And1(grid,center.x,center.y-1);
            }
            if (change) nums++;
        }
        return nums;
    }
    public boolean judge0And1(char[][] grid,int x,int y){
        if (x<grid.length&&y<grid[0].length&&x>=0&&x>=0&&!judge[x][y]){
            if (grid[x][y] == '1') {
                save1Coor.add(new coordinateClass(x,y));
                return true;
            }
            else save0Coor.add(new coordinateClass(x,y));
            judge[x][y] = true;
        }
        return false;
    }
    class coordinateClass {
        public coordinateClass(int x, int y){
            this.x =x;
            this.y = y;
        }
        private int x;
        private int y;
    }
}
