
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Tri {
        int a;
        int b;
        int c;

        Tri(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int batches = in.nextInt();
        ArrayList<Tri> list = new ArrayList<>();
        for (int i = 0; i < batches; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            list.add(new Tri(a, b, c));
        }
        int res  = 0;
        for (Tri tri : list) {
            for (Tri tri1 : list) {
                if (tri.a >= tri1.a) {
                    continue;
                }
                if (tri.b<tri1.b&&tri.c<tri1.c){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);

    }
}