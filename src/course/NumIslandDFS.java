package course;

import java.util.Deque;
import java.util.LinkedList;

public class NumIslandDFS {
    class Coor{
        int i;
        int j;
        Coor(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int numIslands(char[][] grid) {
        Deque<Coor> stack = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    stack.push(new Coor(i, j));
                    count++;
                    while(!stack.isEmpty()){
                        var item = stack.pop();
                        grid[item.i][item.j] = '0';
                        if(item.i+1<grid.length&&grid[item.i+1][item.j]=='1'){
                            stack.push(new Coor(item.i+1, item.j));
                        }
                        if(item.j+1<grid[i].length&&grid[item.i][item.j+1]=='1'){
                            stack.push(new Coor(item.i, item.j+1));
                        }
                        if(item.i-1>=0&&grid[item.i-1][item.j]=='1'){
                            stack.push(new Coor(item.i-1,item.j));
                        }
                        if(item.j-1>=0&&grid[item.i][item.j-1]=='1'){
                            stack.push(new Coor(item.i,item.j-1));
                        }
                    }
                }
            }
        }
        return count;
    }
}