public class OptionalDemo {

  public static void main(String[] args) {
    //创建Optional实例，也可以通过方法返回值得到。
    Optional<String> name = Optional.of("Sanaulla");

    //创建没有值的Optional实例，例如值为'null'
    Optional empty = Optional.ofNullable(null);
null;
a.b()
empty.slkjdf;
empty
    //isPresent方法用来检查Optional实例是否有值。
    if (name.isPresent()) {
      //调用get()返回Optional值。
      System.out.println(name.get());
    }

    try {
      //在Optional实例上调用get()抛出NoSuchElementException。
      System.out.println(empty.get());
    } catch (NoSuchElementException ex) {
      System.out.println(ex.getMessage());
    }

    //ifPresent方法接受lambda表达式参数。
    //如果Optional值不为空，lambda表达式会处理并在其上执行操作。
    name.ifPresent((a) -> {
      System.out.println("The length of the value is: " + a.length());
    });

    //如果有值orElse方法会返回Optional实例，否则返回传入的错误信息。
    System.out.println(empty.orElse("There is no value present!"));
    System.out.println(name.orElse("There is some value!"));

    //orElseGet与orElse类似，区别在于传入的默认值。
    //orElseGet接受lambda表达式生成默认值。
    //
    System.out.println(empty.orElseGet();
    System.out.println(name.orElseGet(() -> "Default Value"));

    try {
      //orElseThrow与orElse方法类似，区别在于返回值。
      //orElseThrow抛出由传入的lambda表达式/方法生成异常。
      empty.orElseThrow(ValueAbsentException::new);
    } catch (Throwable ex) {
      System.out.println(ex.getMessage());
    }

    //map方法通过传入的lambda表达式修改Optonal实例默认值。
    //lambda表达式返回值会包装为Optional实例。
    Optional<String> upperName = name.map((value) -> value.toUpperCase());
    System.out.println(upperName.orElse("No value found"));

    //flatMap与map（Funtion）非常相似，区别在于lambda表达式的返回值。
    //map方法的lambda表达式返回值可以是任何类型，但是返回值会包装成Optional实例。
    //但是flatMap方法的lambda返回值总是Optional类型。
    upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
    System.out.println(upperName.orElse("No value found"));

    //filter方法检查Optiona值是否满足给定条件。
    //如果满足返回Optional实例值，否则返回空Optional。
    Optional<String> longName = name.filter((value) -> value.length() > 6);
    System.out.println(longName.orElse("The name is less than 6 characters"));

    //另一个示例，Optional值不满足给定条件。
    Optional<String> anotherName = Optional.of("Sana");
    Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
    System.out.println(shortName.orElse("The name is less than 6 characters"));

  }

}

// 上述代码输出如下：
// Sanaulla
// No value present
// The length of the value is: 8
// There is no value present!
// Sanaulla
// Default Value
// Sanaulla
// No value present in the Optional instance
// SANAULLA
// SANAULLA
// Sanaulla
// The name is less than 6 characters




public Optional<Foo> findFoo(String id);

public Foo doSomething(String id, Optional<Bar> barOptional);

public class Book {

  private List<Pages> pages;
  private Optional<Index> index;

}
List<Optional<Foo>>

foo("bar", Optional.of("baz"));
foo("bar", Optional.empty());

foo("bar", "baz");
foo("bar", null);

foo("bar", "baz");
foo("bar");

//普通方式
for (Method m : enclosingInfo.getEnclosingClass().getDeclaredMethods()) {
      if (m.getName().equals(enclosingInfo.getName()) ) {
          Class<?>[] candidateParamClasses = m.getParameterTypes();
          if (candidateParamClasses.length == parameterClasses.length) {
              boolean matches = true;
              for(int i = 0; i < candidateParamClasses.length; i++) {
                  if
(!candidateParamClasses[i].equals(parameterClasses[i])) {
                      matches = false;
                      break;
                  }
              }

              if (matches) { // finally, check return type
                  if (m.getReturnType().equals(returnType) )
                      return m;
              }
          }
      }
  }

  throw new InternalError("Enclosing method not found");

//stream 无 optional
Method matching =
      Arrays.asList(enclosingInfo.getEnclosingClass().getDeclaredMethods())
         .filter(m -> Objects.equals(m.getName(), enclosingInfo.getName())
         .filter(m ->  Arrays.equals(m.getParameterTypes(),
parameterClasses))
         .filter(m -> Objects.equals(m.getReturnType(), returnType))
         .getFirst();
//将产生多余变量，并且在返回之前需要判断
if (matching == null)
     throw new InternalError("Enclosing method not found");
return matching;


//stream 包含 optional
   Arrays.asList(enclosingInfo.getEnclosingClass().getDeclaredMethods())
         .filter(m -> Objects.equals(m.getName(), enclosingInfo.getName())
         .filter(m ->  Arrays.equals(m.getParameterTypes(),
parameterClasses))
         .filter(m -> Objects.equals(m.getReturnType(), returnType))
         .findFirst()
         .getOrThrow(() -> new InternalError(...));