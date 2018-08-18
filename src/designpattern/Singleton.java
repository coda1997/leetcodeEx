package designpattern;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    //lazy-load but not thread safe
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
    //lazy-load and thread safe but low efficiency
    public static synchronized Singleton getSingletonInThreadSafe() {
        if (singleton == null) {
            singleton = new Singleton();

        }
        return singleton;
    }

    //more efficiency and thread safe yet, but can be attack by reflection
    public static Singleton getSingletonInThreadSafe2(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }



}
//beat practice is to use enum keyword
enum A{
    a
}