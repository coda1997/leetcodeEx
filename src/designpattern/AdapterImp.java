package designpattern;

interface Duck {
    void quack();
}
interface Turkey{
    void gobble();
}

class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("I am a turkey");
    }
}

class TurkeyAdapter implements Duck{
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}


public class AdapterImp {
    public void tryAdapter(){
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();
    }

}
