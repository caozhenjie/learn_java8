//示例一
public class BoxDemo {

  public static <U> void addBox(U u,
      java.util.List<Box<U>> boxes) {
    Box<U> box = new Box<>();
    box.set(u);
    boxes.add(box);
  }

  public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
    int counter = 0;
    for (Box<U> box: boxes) {
      U boxContents = box.get();
      System.out.println("Box #" + counter + " contains [" +
             boxContents.toString() + "]");
      counter++;
    }
  }

  public static void main(String[] args) {

    java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
      new java.util.ArrayList<>();
    BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
    //直接指明Type parameter 来调用
    // BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
    BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
    BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
    BoxDemo.outputBoxes(listOfIntegerBoxes);
  }
}


//示例二
Map<String, List<String>> myMap = new HashMap<String, List<String>>();
Map<String, List<String>> myMap = new HashMap<>();
Map<String, List<String>> myMap = new HashMap(); // unchecked conversion warning


class MyClass<X> {
  <T> MyClass(T t) {
    // ...
  }
}

new MyClass<Integer>("");
MyClass<Integer> myObject = new MyClass<>("");

//示例三
static <T> List<T> emptyList();
//se7 和 se8 可以
List<String> listOne = Collections.emptyList();
//或者直接指明
List<String> listOne = Collections.<String>emptyList();

void processStringList(List<String> stringList) {
    // process stringList
}
//se7 中将会报错  List<Object> cannot be converted to List<String>
processStringList(Collections.emptyList());List<String>
processStringList(Collections.<String>emptyList());
//在se8 中 OK
//List<T>
processStringList(Collections.emptyList(1,2,3));


//以上例子来源于
//Java 官方文档
