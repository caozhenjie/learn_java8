//当天时间 输出的是已经格式化了的
LocalDate today = LocalDate.now();
System.out.println("Today's Local date : " + today);
// 输出
// Today's Local date : 2014-01-14

//年月日
LocalDate today = LocalDate.now();
int year = today.getYear();
int month = today.getMonthValue();
int day = today.getDayOfMonth();
System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
// 输出
// Today's Local date : 2014-01-14
// Year : 2014 Month : 1 day : 14

//给定时间
LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
System.out.println("Your Date of birth is : " + dateOfBirth);
// 输出 : Your Date of birth is : 2010-01-14

//判断日期是否相等
LocalDate date1 = LocalDate.of(2014, 01, 14); if(date1.equals(today)){
    System.out.printf("Today %s and date1 %s are same date %n", today, date1);
}
// 输出
// today 2014-01-14 and date1 2014-01-14 are same date

//重复时间
LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
MonthDay currentMonthDay = MonthDay.from(today);
if(currentMonthDay.equals(birthday)){
    System.out.println("Many Many happy returns of the day !!");
}else{
    System.out.println("Sorry, today is not your birthday");
}
// 输出: Many Many happy returns of the day !!

//获取当前时间
LocalTime time = LocalTime.now(); System.out.println("local time now : " + time);
// 输出
// local time now : 16:33:33.369 // in hour, minutes, seconds, nano seconds

//增加小时数
LocalTime time = LocalTime.now();
LocalTime newTime = time.plusHours(2); // adding two hours
System.out.println("Time after 2 hours : " + newTime);
// 输出 :
// Time after 2 hours : 18:33:33.369

//增加一周
LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
System.out.println("Today is : " + today);
System.out.println("Date after 1 week : " + nextWeek);
// 输出:
// Today is : 2014-01-14
// Date after 1 week : 2014-01-21


//比较日期的先后
LocalDate tomorrow = LocalDate.of(2014, 1, 15); 、if(tommorow.isAfter(today)){
    System.out.println("Tomorrow comes after today");
}
LocalDate yesterday = today.minus(1, DAYS);
if(yesterday.isBefore(today)){
    System.out.println("Yesterday is day before today");
}

Peroid

// 输出:
// Tomorrow comes after today
// Yesterday is day before today

//java8 中不仅将日期与时间做了分离，也与时区做了分离
LocalDateTime localtDateAndTime = LocalDateTime.now();
ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america );
System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
// 输出 :
// Current date and time in a particular timezone : 2014-01-14T16:33:33.373-05:00[America/New_York]


//检查两个日期隔了多久
LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
Period periodToNextJavaRelease =
Period.between(today, java8Release);
System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths() );
// 输出:
// Months left between today and Java 8 release : 2

//ZoneOffset 代表某个时区，OffsetDateTime 主要是给机器看的，如果给人看就用ZoneDateTime
LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
ZoneOffset offset = ZoneOffset.of("+05:30");
OffsetDateTime date = OffsetDateTime.of(datetime, offset);
System.out.println("Date and Time with timezone offset in Java : " + date);
// 输出 :
// Date and Time with timezone offset in Java : 2014-01-14T19:30+05:30

//获得当前时间戳
Instant timestamp = Instant.now();
System.out.println("What is value of this instant " + timestamp);
// 输出 :
// What is value of this instant 2014-01-14T08:33:33.379Z


// clock 的定义
// A clock providing access to the current instant, date and time using a time-zone.
// clock.instant() 方法
// Gets the current instant of the clock.
// This returns an instant representing the current instant as defined by the clock.
// instant.now(clock clock) 方法
// Gets the current instant of the clock.
// This returns an instant representing the current instant as defined by the clock.
