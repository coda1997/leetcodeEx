package leetCode;

public class Ex1217 {
    public int minCostToMoveChips(int[] position) {
        int[] t = new int[2];
        for (int i : position) {
            t[i&1]++;
        }   
        return (t[0] < t[1]) ? t[0]:t[1];
    }
}
