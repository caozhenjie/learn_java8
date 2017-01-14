// 转换大写
List<String> output = wordList.stream().
map(String::toUpperCase).
collect(Collectors.toList());



// 平方数
List<Integer> nums = Arrays.asList(1, 2, 3, 4);
List<Integer> squareNums = nums.stream().
map(n -> n * n).
collect(Collectors.toList());
// 这段代码生成一个整数 list 的平方数 {1, 4, 9, 16}。
// 从上面例子可以看出，map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素。还有一些场景，是一对多映射关系的，这时需要 flatMap。
// 一对多
Stream<List<Integer>> inputStream = Stream.of(
 Arrays.asList(1),
 Arrays.asList(2, 3),
 Arrays.asList(4, 5, 6)
 );
List<STring< outputStream = inputStream.
flatMap((childList) -> childList.stream()).collection(To)
// flatMap 把 input Stream 中的层级结构扁平化，
// 就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。

 // 留下偶数
Integer[] sixNums = {1, 2, 3, 4, 5, 6};
Integer[] evens =
Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);


forEach
forEach 方法接收一个 Lambda 表达式，然后在 Stream 的每一个元素上执行该表达式。
// Java 8
// List<Person>
roster.stream()
 .filter(p -> p.getGender() == Person.Sex.MALE)
 .forEach(p -> System.out.println(p.getName()));
// Pre-Java 8
for (Person p : roster) {
 if (p.getGender() == Person.Sex.MALE) {
 System.out.println(p.getName());
 }
}


peek 对每个元素执行操作并返回一个新的 Stream
Stream.of("one", "two", "three", "four")
.filter(e -> e.length() > 3)
.peek(e -> System.out.println("Filtered value: " + e))
.map(String::toUpperCase)
.peek(e -> System.out.println("Mapped value: " + e))
.collect(Collectors.toList());

// 这是一个 termimal 兼 short-circuiting 操作，它总是返回 Stream 的第一个元素，或者空。
// 找出全文的单词，转小写，并排序
List<String> words = br.lines().
 flatMap(line -> Stream.of(line.split(" "))).
 filter(word -> word.length() > 0).
 map(String::toLowerCase).
 distinct().
 sorted().
 collect(Collectors.toList());


 按照年龄归组
 Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
  limit(100).
  collect(Collectors.groupingBy(Person::getAge));
 Iterator it = personGroups.entrySet().iterator();
 while (it.hasNext()) {
  Map.Entry<Integer, List<Person>> persons = (Map.Entry) it.next();
  System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
 }

// Age 0 = 2
// Age 1 = 2
// Age 5 = 2
// Age 8 = 1
// Age 9 = 1
// Age 11 = 2

// 按照未成年人和成年人归组
Map<Boolean, List<Person>> children = Stream.generate(new PersonSupplier()).
 limit(100).
 collect(Collectors.partitioningBy(p -> p.getAge() < 18));
System.out.println("Children number: " + children.get(true).size());
System.out.println("Adult number: " + children.get(false).size());

// Children number: 23
// Adult number: 77
