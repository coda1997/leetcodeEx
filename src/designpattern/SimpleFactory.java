package designpattern;

public class SimpleFactory {
    public static SimpleFactory simpleFactory = new SimpleFactory();

    public ProductA createProductA(){
        return new ProductA();
    }

    public ProductB createProductB(){
        return new ProductB();
    }
}


class ProductA{}
class ProductB{}