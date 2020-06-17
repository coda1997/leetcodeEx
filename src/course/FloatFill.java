package course;

import java.util.Deque;
import java.util.LinkedList;

public class FloatFill{
    class Coor{
        int i;
        int j;
        Coor(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        Deque<Coor> stack = new LinkedList<>();
        stack.push(new Coor(sr, sc));
        int color = image[sr][sc];
        if(color==newColor){
            return image;
        }
        while(!stack.isEmpty()){
            var temp = stack.pop();
            image[temp.i][temp.j]=newColor;
            for (int i = -1; i <=1; i+=2) {
                var t = temp.i+i;
                if(t>=0&&t<image.length&&image[t][temp.j]==color){
                    stack.push(new Coor(t,temp.j));
                }
                var p = temp.j+i;
                if(p>=0&&p<image[temp.i].length&&image[temp.i][p]==color){
                    stack.push(new Coor(temp.i,p));
                }
            }
        }
        
        return image;
    }

}