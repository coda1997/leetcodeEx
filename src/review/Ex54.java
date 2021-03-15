package review;

import java.util.ArrayList;
import java.util.List;

public class Ex54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int colL = 0;
        int colR = matrix[0].length;
        int rowU = 0;
        int rowD = matrix.length;
        int x = 0;
        int y = 0;
        int strideX = 0;
        int strideY = 1;
        while (colL < colR && rowU < rowD) {
            res.add(matrix[x][y]);
            int tX = x+strideX;
            int tY = y+strideY;
            if (tX>=rowU&&tX<rowD&&tY>=colL&&tY<colR){
                //it is legal, updating the state;
                x = tX;
                y = tY;
            }else{
                //touch the fence, do the rotation and change the bound;
                if (strideY==1){
                    strideX = 1;
                    strideY = 0;
                    rowU++;
                }else if (strideX == 1){
                    strideX = 0;
                    strideY = -1;
                    colR--;
                }else if (strideY==-1){
                    strideX = -1;
                    strideY = 0;
                    rowD--;
                }else{
                    strideX = 0;
                    strideY = 1;
                    colL++;
                }
                x += strideX;
                y += strideY;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex54();
        o.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).forEach(System.out::print);
    }
}
