package temp;

import java.util.Arrays;

public class ForldTemp {
    public void temp(){
        int[][] distance = new int[4][4];
        for (int[] ints : distance) {
            Arrays.fill(ints, -1);
        }
        distance[0][2] = distance[2][0] = 1;
        distance[2][3] = distance[2][3] = 1;
        distance[3][1] = distance[1][3] = 1;

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if(i==0&&j==1){
                        System.out.println("here");
                    }
                    if (distance[i][k] > 0 && distance[k][j] > 0) {
                        distance[i][j] = distance[i][k] * distance[k][j];
                    }
                }
            }
        }
        for (var item :
                distance) {
            System.out.println(Arrays.toString(item));
        }
    }

    public static void main(String[] args) {
        var o = new ForldTemp();
        o.temp();
    }
}
