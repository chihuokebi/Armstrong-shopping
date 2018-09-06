/**
 * 父类
 */
public class Parent {
    //定义成员变量
    //static int a = getA();

    /*static {
        //Parent静态代码块
        System.out.println("Parent静态代码块");
    }*/

    //int b = getB();

    {
        //Parent构造代码块
        System.out.println("Parent构造代码块");
    }

    Parent() {
        //Parent构造函数
        System.out.println("Parent构造函数");
    }

    public static int getA() {
        //Parent A 方法
        System.out.println("Parent A 方法");
        return 1;
    }

    public static int getB() {
        //Parent B 方法
        System.out.println("Parent B 方法");
        return 2;
    }
}
