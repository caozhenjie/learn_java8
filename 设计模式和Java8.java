//定义：将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，
//对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能
//宏命令 一系列（一般是最常使用到的操作）自定义为一个步骤。也就是用户执行一系列操作
//
//对于大多数请求——响应模式的功能，比较适合使用命令模式。
// 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
// 系统需要在不同的时间指定请求、将请求排队（如：线程池+工作队列）和执行请求。
// 系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作（比如系统挂掉之后重启做一些恢复操作，还有数据库的事务等）。
// 系统需要将一组操作组合在一起，即支持宏命令。

public class Editor {
  public void save() {
    System.out.println("save");
  }
  public void open(){
    System.out.println("open");
  }
}

public interface Command {
  public void execute();
}

public Class Save implements Command {
  private final Editor editor;
  public Save(Editor editor){
    this.editor = editor;
  }
  @Override
  public void execute(){
    editor.save();
  }
}

public Class Open implements Command {
  private final Editor editor;
  public Open(Editor editor) {
    this.editor = editor;
  }
  @Override
  public void execute(){
    editor.open();
  }
}


public Class Invoker {
  private final List<Command> commands;

  public Invoker(){
    commands = new ArrayList<>();
  }
  public void add(Command command) {
    commands.add(command);
  }
  public void run() {
    commands.forEach(Command::perform);
  }
}

Invoker invoker = new Invoker();
invoker.add(new Open(editor));
invoker.add(new Save(editor));
invoker.run();

//java8 中写法，能让代码更简洁，去掉大量的不必要代码，让代码意图更加明显
Invoker invoker = new Macro();
invoker.add(() -> editor.open());
invoker.add(() -> editor.save());
invoker.run();
