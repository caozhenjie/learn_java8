//现在的任务 我们有一个名字列表，其中有一些条目有单个字符组成，、
//现在的任务是 将除去单字符条目以外的列表内容，放在一个逗号分隔的字符串里返回，且每个名字首字母都要大写。

//命令式编程的解法
//命令式编程鼓励程序员在循环内部去改变状态，显示 filter，过滤，去掉单字符条目，transform 变换列表
//使得首字母变成大写，接着聚合  得到单个字符串
//依赖于相同的低层次机制（对列表进行迭代）
public String cleanNames(List<String> listofNames) {
StringBuilder result = new StringBuilder();
for(int i=0; i < listOfNames.size; i++) {
  if(listOfNames.get(i).length() > 1) {
    result.append(capitalizeString(listOfNames.get(i)).append(","));
  }
}
return result.substring(0,result.length()-1).toString();
}

public String capitalizeString(String s) {
  return s.substring(0,1).toUpperCase() + s.substring(1,s.length);
}

//函数式编程的处理
//可以换做语言来描述
// list<String> 小于1的不要， 首字母要大写，返回一整个字符串
public String cleanNames(List<String> names)  {
  if(names = null) return "";
  return names.stream().filter(name -> name.length > 1)
                       .map(name -> capitalizeString(name))
                       .collect(Colllections.joining(",")).
}

//parallel()
//函数式编程的好处，获得更好的抽象，首先会让我们换一种角度去归类问题，看到问题共性。其次让埋头于实现细节的开发者
//看到原先视野之外的解决方案。
//例如，如果我们要把上面的改成多线程，命令式变成工作量不小，因为是由我们去控制低层次的迭代细节。那么线程相关
//的工作也就只要有我们穿插进去。
