package leetCode;

public class Ex1217 {
    public int minCostToMoveChips(int[] position) {
        int[] t = new int[2];
        for (int i : position) {
            t[i&1]++;
        }   
        return Math.min(t[0],t[1]);
    }
}
