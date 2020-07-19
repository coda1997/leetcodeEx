package course;

public class HIndex {
    public int hIndex(int[] citations) {
        int[] counts = new int[citations.length+1];
        for (int item : counts) {
            counts[Math.min(citations.length, item)]++;
        }
        int res = citations.length;
        for (int i = counts[citations.length]; res> i; i+= counts[res]) {
            res--;
        }
        return res;
    }

}