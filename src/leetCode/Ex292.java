package leetCode;
/**
 * 292. Nim 游戏
 * 必赢游戏，小学奥赛题
 * 
 */
public class Ex292 {
    public boolean canWinNim(int n) {
        // bitwise operation is faster then mod and divide
        // return n & 3;
        return n%4==0;
    }
}