package designpattern;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void nofityObserver();
}

class Book implements Subject{
    private List<Observer> observers;
    private String msg = "book is selling";
    public Book() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void nofityObserver() {
        observers.forEach(observer -> {
            observer.update(msg);
        });
    }
}
