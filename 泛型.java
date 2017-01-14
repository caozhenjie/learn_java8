
// 1.7 之前的写法而且也不支持方法签名推断
List<String> list = new ArrayList<String>();

List<String> list1 = new ArrayList<>();
//这句话会报错
list1.addAll(Arrays.asList());


//菱形操作符
List<String> list1 = new ArrayList<>();

List<String> list1 = new ArrayList<>();
//这句话会仍会错
list1.addAll(Arrays.asList());




//类型推断
public class BoxDemo {

    public static <U> void addBox(U u,java.util.List<Box<U>> boxes) {

    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {

    }

    public static void processStringList(List<String> stringList) {
    }

    public static void main(String[] args) {
      
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
            new java.util.ArrayList<>();
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);

        processStringList(Collections.<String>emptyList());
    }
}
