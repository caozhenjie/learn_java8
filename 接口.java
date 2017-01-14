public interface Parent {
  public void message(String body);
  public default void welcome(){
    message("Parent Hi");
  }
  public String getLastMessage();
}

//多重继承
public interface Jukebox {
  public default String rock(){
    return "test1";
  }
}
public interface Carriage {
  public default String rock(){
    return "test2";
  }
}
public class MusicalCarriage implements Carriage,Jukebox {
  @override
  public String rock(){
    //如果不这样指定，编译器会报错
    return Carriage.super.rock()；
  }
}
//多重继承的规则
//类胜于接口  子类胜于父类
