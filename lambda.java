

//lambda表达式
Runnable noArgument = () -> System.out.println("Hello World");
ActionListener oneArgument = event -> System.out.println("Button Clicked");
Runnable multiStatement = () -> {
  System.out.println("Hello");
  foo();

}
BinaryOperator<Long> add = (x,y) ->  x+y;
BinaryOperator<Long> add2 = (Long x,Long y) -> x+y;


//数组例子
String[] array = {"Hello","world"};

//延迟加载
logger.finest("x "+x+",y:"+expre);
logger.finest((x) -> "x "+x+",y:"+y);

public void finest(String msg) {
        log(Level.FINEST, msg);
    }

    public void log(Level level, String msg) {
    if (!isLoggable(level)) {
        return;
    }
    LogRecord lr = new LogRecord(level, msg);
    doLog(lr);
}


// effectively final
 fina String str = "test1";
Runnable noArgu = () -> System.out.println(test);
