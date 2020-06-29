package course;

public class CountDigitOne {
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i*=10) {
            var divider = i*10;
            count += n/divider*i + Math.min(i, Math.max(0,n%divider-i+1));
        }
        return count;
    }
}