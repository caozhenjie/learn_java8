方法引用可以在不调用某个方法的情况下引用一个方法。方法引用是另外一种实现 functional interface 的方法。在某些情况下，方法引用可以进一步简化代码。

objectName::instanceMethod
// (args) -> expression.instanceMethod(args);
x -> System.out.println(x)  // lambda 语法
A::println  // method reference 语法
// public final static PrintStream out = null;
// out.println(x);


ClassName::staticMethod
// (args) -> ClassName.staticMethod(args);
(x, y) -> Math.max(x,y); // lambda 语法糖
Math::max  // method referenca 语法
stream.filt(Math::max)

ClassName::instanceMethod
// (instance, args) -> instance.instanceMethod(args);
x -> x.toLowerCase() // lambda 语法
String::toLowerCase  // method reference 语法


3.5 Construct reference
构造方法引用可以在不创建对象的情况下引用一个构造方法
// x -> new BigDecimal(x)
BigDecimal::new

Shuang Gan




interface FIface<T> {
    int testMethod(T a, T b);
}

class Test2 {

    private String str;

    Test2(String str) {
        this.str = str;
    }

    int ok(Test2 test2) {
        System.out.println("Currnet String : "+ this.str);//Refer to t1
        System.out.println("Test String : "+test2.str);//Refer to t2
        return 0;
    }

}

public class Test {

    public static <T> int checkCall(T t1, T t2, FIface<T> fiFace) {
        //Here Test2 :: ok is equivalent to t1.ok(t2)
        return fiFace.testMethod(t1, t2);
    }

    public static void main(String[] args) {
        checkCall(new Test2("a"), new Test2("b"), Test2 :: ok);
    }

}
