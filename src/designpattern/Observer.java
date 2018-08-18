package designpattern;

public interface Observer {
    void update(String msg);
}

class Reader implements Observer{

    public Reader(Subject subject) {
        subject.registerObserver(this);
    }
    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}