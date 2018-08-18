package designpattern;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestObserver {

    private ArrayList<Observer> observers;
    private Subject subject;
    @Before
    public void initTestCase(){
        subject = new Book();
        observers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            observers.add(new Reader(subject));
        }
    }

    @Test
    public void testSubscribe(){
        subject.nofityObserver();
    }

}
