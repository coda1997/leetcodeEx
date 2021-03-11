package temp.tree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThread {
    public void test() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        int number = 10;
        var tasks = new Runnable[number];
        for (int i = 0; i < number; i++) {
            final int t = i;
            tasks[i] = () -> System.out.println(t);
        }
        for (int i = 0; i < number; i++) {
            fixedThreadPool.submit(tasks[i]);
        }
        var stoppedTasks = fixedThreadPool.shutdownNow();
        fixedThreadPool.awaitTermination(10, TimeUnit.HOURS);
        System.out.println("------------------------");
        System.out.println(stoppedTasks.size());
    }

    public static void main(String[] args) throws InterruptedException {
        var t = new MultiThread();
        t.test();
    }
}
