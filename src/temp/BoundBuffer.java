package temp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundBuffer {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final int capacity = 100;
    private Object[] items = new Object[capacity];
    private int takep = 0, putp = 0, count = 0;

    public void put(Object o) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity) {
                notFull.await();
            }
            count++;
            items[putp++] = o;
            if (putp == capacity) {
                putp = 0;//or putp %= capacity
            }
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            count--;
            var res = items[takep--];
            if (takep == 0) {
                takep = capacity-1;
            }
            notFull.signal();
            return res;
        }finally {
            lock.unlock();
        }
    }
}
