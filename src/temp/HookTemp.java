package temp;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class HookTemp {
    private static class TestView{

        private MyClassNeedHooked myClassNeedHooked;

        static class MyClassNeedHooked{
            public void hello(){
                System.out.println("hello not hooked.");
            }
        }


        private ProcIn procIn;
    }

    private static class Other extends TestView.MyClassNeedHooked{
        @Override
        public void hello() {
            System.out.println("method is hooked blow.");
            super.hello();
        }
    }

    private interface ProcIn{
        void test();
    }

    public static void main(String[] args) throws Exception{
        TestView testView = new TestView();
//        testView.myClassNeedHooked = new TestView.MyClassNeedHooked();
//        testView.myClassNeedHooked.hello();

        Field field = TestView.class.getDeclaredField("myClassNeedHooked");
        field.setAccessible(true);
//        System.out.println(field.getName());

        Other other = new Other();
        field.set(testView, other);
        testView.myClassNeedHooked.hello();


        Field field2 = TestView.class.getDeclaredField("procIn");
        field2.setAccessible(true);
        ProcIn newIns = (ProcIn) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{ProcIn.class}, (proxy, method, args1) -> {
                    System.out.println("method is proxyed, method is "+method);
                    return null;
            }
        );

        field2.set(testView, newIns);
        testView.procIn.test();
    }
}
