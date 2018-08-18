package designpattern;

interface Beverage{
    double cost();
}

class DerkRoast implements Beverage{
    @Override
    public double cost() {
        return 1;
    }
}

class HouseBlend implements Beverage{


    @Override
    public double cost() {
        return 1;
    }
}

abstract class CondimentDecorator implements Beverage{
    protected Beverage beverage;
}

class Milk extends CondimentDecorator{
    public Milk(Beverage beverage) {
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return 1+beverage.cost();
    }
}

class Mocha extends CondimentDecorator{
    public Mocha(Beverage beverage) {
        this.beverage=beverage;
    }
    @Override
    public double cost() {
        return 1+beverage.cost();
    }
}

public class DecoratorImp {
    public void tryDecorator(){
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }

    public static void main(String[] args) {
        new DecoratorImp().tryDecorator();
    }
}
