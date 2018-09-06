/**
 * 子类
 */
public class Child extends Parent {
    //static int c = getC();

    /*static {
        System.out.println("Child静态代码块");
    }*/

    //int d = getD();

    {
        System.out.println("Child构造代码块");
    }

    Child() {
        System.out.println("Child构造函数");
    }

    static int getC() {
        System.out.println("Child C 方法");
        return 1;
    }

    static int getD() {
        System.out.println("Child D 方法");
        return 2;
    }
}
