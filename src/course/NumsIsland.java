package course;

import java.util.LinkedList;
import java.util.Queue;

public class NumsIsland {
    class Coor{
        int i;
        int j;
        Coor(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int numIslands(char[][] grid) {
        Queue<Coor> queue = new LinkedList<>();
        int ilen = grid.length;
        int count=0;
        if(ilen==0){
            return count;
        }
        int jlen = grid[0].length;
        for (int i = 0; i < ilen; i++) {
            for (int j = 0; j <jlen; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    queue.add(new Coor(i,j));
                    grid[i][j]='0';
                    while(!queue.isEmpty()){
                        var temp = queue.poll();
                        if(temp.i+1<ilen&&grid[temp.i+1][temp.j]=='1'){
                            queue.add(new Coor(temp.i+1,temp.j));
                            grid[temp.i+1][temp.j]='0';
                        }
                        if(temp.j+1<jlen&&grid[temp.i][temp.j+1]=='1'){
                            queue.add(new Coor(temp.i, temp.j+1));
                            grid[temp.i][temp.j+1]='0';

                        }
                        if(temp.i-1>=0&&grid[temp.i-1][temp.j]=='1'){
                            queue.add(new Coor(temp.i-1,temp.j));
                            grid[temp.i-1][temp.j]='0';
                        }
                        if(temp.j-1>=0&&grid[temp.i][temp.j-1]=='1'){
                            queue.add(new Coor(temp.i,temp.j-1));
                            grid[temp.i][temp.j-1]='0';   
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println( new NumsIsland().numIslands(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}}));
    }
}