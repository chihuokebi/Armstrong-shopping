public class Test01 {
    public static void main(String[] args) {
        StringBuffer x = new StringBuffer("123");
        //String x = new String("123");
        //String y = new String("123");
        //String x = "123";
        System.out.println(x);
        change(x);
        System.out.println(x);
        //System.out.println(x == y);
    }

    private static void change(StringBuffer x) {
       x.append("aaa");
      // x = new StringBuffer("123aaa");
    //    x = "abc";
    }
}
