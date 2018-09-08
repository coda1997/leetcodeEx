import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {

    static class Node{
        int key;
        int value;
    }

    private static LinkedList<Node> linkedList = new LinkedList<>();
    private static HashMap<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int scale = in.nextInt();

        while (in.hasNext()){
            String c = in.next();
            int key = in.nextInt();
            if (c.equals("p")){
                int value = in.nextInt();
                Node t = new Node();
                t.key=key;t.value=value;
                if (map.containsKey(key)){
                    map.get(key).value=value;
                    continue;
                }
                if (linkedList.size()>=scale){
                    Node n=linkedList.removeFirst();
                    linkedList.addLast(t);
                    map.remove(n.key);
                    map.put(key,t);
                }else {
                    linkedList.addLast(t);
                    map.put(key,t);
                }
            }else {
                if(map.containsKey(key)){
                    Node n = map.get(key);
                    linkedList.remove(n);
                    linkedList.addLast(n);
                    System.out.println(n.value);
                }else {
                    System.out.println(-1);
                }
            }
        }
    }
}