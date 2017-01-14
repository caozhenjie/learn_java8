List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
System.out.println(“sum is:”+nums.stream().filter(num -> num != null).
            distinct().mapToInt(num -> num * 2).
            peek(System.out::println).skip(2).limit(4).sum());

// 给定一个Integer类型的List，获取其对应的Stream对象，然后进行过滤掉null，再去重，再每个元素乘以2
// 再每个元素被消费的时候打印自身，在跳过前两个元素，最后去前四个元素进行加和运算
// IntStream  boxing unboxing


//flatMap和map的区别
  <R> Stream<R> map(Function<? super T, ? extends R> mapper);
  <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
//   map :: Stream T -> (T -> R) -> Stream R,
//  flatMap :: Stream T -> (T -> Stream R) -> Stream R


List<Integer> listOfIntegers = Stream.of("1", "2", "3", "4")
                            .map(Integer::valueOf)
                            .collect(Collectors.toList());

List evens = Arrays.asList(2, 4, 6);
List odds = Arrays.asList(3, 5, 7);
List primes = Arrays.asList(2, 3, 5, 7, 11);
List numbers = Stream.of(evens, odds, primes)
                     .flatMap(list -> list.stream())
                     .collect(Collectors.toList());
                     System.out.println("flattend list: " + numbers);
 // Output: flattend list: [2, 4, 6, 3, 5, 7, 2, 3, 5, 7, 11]
List<List<String>> -> List<String>


//collect 方法签名
<R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);

List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
    List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null)
            collect(() -> new ArrayList<Integer>(),
                    (list, item) -> list.add(item),
                    (list1, list2) -> list1.addAll(list2));

//另一重载的方法
//<R, A> R collect(Collector<? super T, A, R> collector);
<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
                collect(Collectors.toMap;

//reduce 操作
//方法签名 Optional<T> reduce(BinaryOperator<T> accumulator);
//第一次执行的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素
//这个方法返回值类型是Optional
List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());
// 方法签名  T reduce(T identity, BinaryOperator<T> accumulator);
List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));

//count
List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
System.out.println("ints sum is:" + ints.stream().count());
