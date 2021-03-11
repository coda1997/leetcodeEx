package temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.*;

public class Test {
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        var scheduledThreadPool = Executors.newScheduledThreadPool(5);
        var f = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        System.out.println(f.get());
    }



    public static void main(String[] args) {
        var o = new Test();

    }
}
