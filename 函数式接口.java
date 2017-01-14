// 函数式接口和所谓的Single Abstract Method interfaces一样，就是只包含一个抽象方法的接口，表达的是逻辑上的单一功能
//所以这也是一个函数式接口
public interface Runnable {
    public abstract void run();

}

//即使该不加该注解，任然有效，这个注解只是强制编译器去检查 是否符合函数式接口的定义
@FunctionalInterface
public interface ITrade {
  public boolean check(Trade t);
}



ITrade newTredeChecker = (Trade t) -> t.getStatus().equals("NEW");
A a = new A();
ITrade newTredeChecker = (args) ->a.b();

// Lambda for big trade
ITrade bigTradeLambda = ;
// Lambda that checks if the trade is a new large google trade
ITrade issuerBigNewTradeLambda = (t) -> {
    return t.getIssuer().equals("GOOG") &&
           t.getQuantity() > 10000000 &&
           t.getStatus().equals("NEW");
  };

private List<Trade> filterTrades(ITrade tradeLambda, List<Trade> trades) {
List<Trade> newTrades = new ArrayList<>();

  for (Trade trade : trades) {
    if (tradeLambda.check(trade)) {
      newTrades.add(trade);
    }
  }
  return newTrades;
}

// Big trades function is passed
List<Trade> bigTrades =
  client.filterTrades(bigTradeLambda,tradesCollection);

// "BIG+NEW+ISSUER" function is passed
List<Trade> bigNewIssuerTrades =
  client.filterTrades(issuerBigNewTradeLambda,tradesCollection);




//java8 中提供的函数式接口
@FunctionalInterface
public interface Predicate<T> {
  boolean test(T t);
}
Predicate<Trade> largeTrade = (Trade t) -> t.isBigTrade();
Predicate<Trade> cancelledTrade = t -> t.isCancelledTrade();
Predicate<String> emptyStringChecker = s -> s.isEmpty();
Predicate<Employee> isExec = emp -> emp.isExec();
boolean cancelledTrade = cancelledTrade.test(t);
boolean executive = isExec.test(emp);

//java8 中提供的函数式接口，T 为输入,R 为返回
@FunctionalInterface
public interface Function<T, R> {
  R apply(T t);
}

public foo(Function sfs,param some) {
  sfs.apply(some)
}
//摄氏度 变为  华氏温度计
Function<Integer,Double> centigradeToFahrenheitInt = x -> new Double((x*9/5)+32);

Function<String, Integer> stringToInt = x -> Integer.valueOf(x);

// 测试
System.out.println("Centigrade to Fahrenheit: "+centigradeToFahrenheitInt.apply(centigrade))
System.out.println(" String to Int: " + stringToInt.apply("4"));

// Function to calculate the aggregated quantity of all the trades - taking in a collection and returning an integer!
Function<List<Trade>,Integer> aggegatedQuantity = t -> {
  int aggregatedQuantity = 0;
  for (Trade t: t){
    aggregatedQuantity+=t.getQuantity();
  }
  return aggregatedQuantity;
};

//后面Stream 中将会提及 下面用到的高阶函数
aggregatedQuantity =
  trades.stream()
  .map((t) -> t.getQuantity())
  .reduce(0, Integer::sum);

// Or, even better
aggregatedQuantity =
  trades.stream()
  .map((t) -> t.getQuantity())
  .sum();

  //java8 中提供的函数式接口，T 为输入 无返回
  @FunctionalInterface
  public interface Consumer<T> {
    void accept(T t);
  }

  //java8 中提供的函数式接口，T 为返回 ，无输入
  @FunctionalInterface
public interface Supplier<T> {
  T get();
}
//java8 中提供的函数式接口，T U 为输入，R为返回
@FunctionalInterface
public interface BiFunction<T, U, R> {
  R apply(T t, U u);
}

//java8 中提供的函数式接口，T  为输入，T为返回
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, R> {
}
//java8 中提供的函数式接口，T和T为输入，T为返回
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
}
