//使用
@MyAnnotation(name="someName",  value = "Hello World")
public class TheClass {
}

//定义          class
//source
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
  public String name();
  public String value();
}
//方法注解 Target(ElementType.METHOD)
public class TheClass {
  @MyAnnotation(name="someName",  value = "Hello World")
  public void doSomething(){}
}
//参数注解 Target(ElementType.PARAMETER)
public class TheClass {
  @MyAnnotation(name="someName",  value = "Hello World")
  public String myField = null;
}



         //初始化对象时
         String myString = new @NotNull String();
         //对象类型转化时
         myString = (@NonNull String) str;
         //使用 implements 表达式时
         class MyList<T> implements @ReadOnly List<@ReadOnly T>{
                             ...
          }
          //使用 throws 表达式时
          public void validateValues() throws @Critical ValidationFailedException{
           }
           //定义
          @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
          public  @interface MyAnnotation {
          }

      < T>  class test{

      }

      @Access(role="SuperAdministrator")
      @Access(role="Administrator")
      public void doCheck() {
      }

      @Repeatable(AccessContainer.class)
    public @interface Access {
                   String role();
           }

      public @interface AccessContainer {
             Access[] value();
      }
