package review;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] offset = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int num = 1;
        int colL = 0, colR = n, rowU = 0, rowD = n;
        int x = 0;
        int y = 0;
        int len = n*n;
        int index = 0;
        while (num<=len){
            res[x][y] = num++;
            int tX = x+offset[index][0];
            int tY = y+offset[index][1];
            if (tX >= rowU && tX < rowD && tY >= colL && tY < colR) {
                x = tX;
                y = tY;
            }else{
                if (tY==colR){
                    index = 1;
                    rowU++;
                }else if (tX==rowD){
                    index = 2;
                    colR--;
                }else if (tY<colL){
                    index = 3;
                    rowD--;
                }else{
                    index = 0;
                    colL++;
                }
                x += offset[index][0];
                y += offset[index][1];
            }
        }
        return res;
    }
}
