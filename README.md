# 环境配置

#### 通过设置tomcat启动参数 实现用户的区域region和语言locale language的设定

D:\JAVA\apache-tomcat-9.0.37\bin\catalina.bat

![img](http://dl2.iteye.com/upload/attachment/0110/5773/92ee5b8a-a187-3fc7-a15c-ffea0037d8e8.png)
 通过启动参数 -Duser.lanaguage和-Duser.region来实现。



# 创建web动态项目

### 一.创建JavaWeb

#### 1.第一步

点击左上角的File-->New-->Project

![img](https://images2018.cnblogs.com/blog/1454132/201807/1454132-20180731143215919-426313659.png)

#### 2.第二步

1.找到Java Enterprise之后，在Application Sever中找到自己的Tomcat，同时勾选中Web Application

![img](https://images2018.cnblogs.com/blog/1454132/201807/1454132-20180731144033951-271721676.png)

![img](https://images2018.cnblogs.com/blog/1454132/201807/1454132-20180731144141278-1918700554.png)

![img](https://images2018.cnblogs.com/blog/1454132/201807/1454132-20180731144301189-339368721.png)

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805202802381-1917813798.png)

2.第一项是你的工程名字，随便取啦，第二个是你的工程路径，选择好之后点击finish

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805202929301-2013529373.png)

3.创建classes和lib文件夹，名字不可改

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805203316940-1075771412.png)

像这样

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805203933674-1440708394.png)

#### 3.第三步

1.在File中找到Project Structure

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805203719506-303249541.png)

 2.点击Modules ,选择Paths,选中Use module compile output path ,把路径改成刚刚创建的classes文件夹

 ![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805204113541-1773742664.png)

3.ok后再点旁边的Dependencies,点击"+"号，选择1 JARs or directories ，

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805204408825-1094008050.png)

4，选择你刚刚创建的lib文件夹，OK

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805204428409-781933398.png)

5.选中jar Directory。

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805204449499-942794484.png)

#### 4.第四步

1.回到主界面后，点击Run ，选择Edit Configurations

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805204612199-110871540.png)

2.看tomcat已经有啦，这是java Enterprise的好处啦，点击Deployment ,

 ![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805204854675-48059891.png)

3.点击右上角的三角形

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805205113279-1570756414.png)

 4.运行成功。

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805205235849-1415359416.png)

至此，intellij idea创建并设置javaweb工程全部完成，下面是在其中编写并运行Servlet。

### 二.创建**Servlet**

 1.先下src文件加下创建一个servlet  Hellow.java文件

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805212239225-1035554572.png)

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805212325904-1789458385.png)

2.对Hello.java进行编译

```
`import` `javax.servlet.ServletException;``import` `javax.servlet.annotation.WebServlet;``import` `javax.servlet.http.HttpServlet;``import` `javax.servlet.http.HttpServletRequest;``import` `javax.servlet.http.HttpServletResponse;``import` `java.io.IOException;``import` `java.io.PrintWriter;` `@WebServlet``(name = ``"Hello"``)``public` `class` `Hello ``extends` `HttpServlet {``    ``protected` `void` `doPost(HttpServletRequest request, HttpServletResponse response) ``throws` `ServletException, IOException {` `    ``}``    ``protected` `void` `doGet(HttpServletRequest request, HttpServletResponse response) ``throws` `ServletException, IOException {``        ``//设置响应内容类型``        ``response.setContentType(``"text/html"``);` `        ``//设置逻辑实现``        ``PrintWriter out = response.getWriter();``        ``out.println(``"<h1>Servlet后台</h1>"``);``    ``}``}`
```

3.编写web.xml配置文件

```
`<?xml version=``"1.0"` `encoding=``"UTF-8"``?>``<web-app xmlns=``"http://xmlns.jcp.org/xml/ns/javaee"``         ``xmlns:xsi=``"http://www.w3.org/2001/XMLSchema-instance"``         ``xsi:schemaLocation=``"http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"``         ``version=``"4.0"``>` `    ``<servlet>``        ``<servlet-name>Hello</servlet-name>``        ``<servlet-``class``>Hello</servlet-``class``>``    ``</servlet>` `    ``<servlet-mapping>``        ``<servlet-name>Hello</servlet-name>``        ``<url-pattern>/Hello</url-pattern>``    ``</servlet-mapping>` `</web-app>`
```

4.运行Servlet,发现在classes目录下会生成Hello.class文件

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805212856649-745432396.png)

 

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180805213047785-2027544378.png)

5.重新编写index.jsp文件

 

```
`<%@ page contentType=``"text/html;charset=UTF-8"` `language=``"java"` `%>``<html>``  ``<head>``    ``<title>$Title$</title>``  ``</head>``  ``<body>``    ``<a href=``"Hello"``>第一个动态web项目</a>``  ``</body>``</html>`
```

　　![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180806094934219-1517556482.png)

6.完成

![img](https://images2018.cnblogs.com/blog/1454132/201808/1454132-20180806095038196-2104967380.png)





# 项目结构

包路径：src-->xyz-->huowang-->hwblog-->

constant:

dao:
   	dao接口存放访问数据库的操作接口类所属层次：数据访问层
    -->impl


​		基础dao实现类，实现BaseDao接口，存放访问数据库的操作接口的实现类；所属层次：数据访问层


domain:
 		封装数据（bean）javabean，存放系统的JavaBean类(只包含简单的属性以及属性对应的get和set方法，

​		不包含具体的业务处理方法)，提供给【数据访问层】、【业务处理层】、【Web层】来使用

​		所属层次： domain(域模型)层

exception:
    

service:
   	 基础service接口
   	 存放处理系统业务接口类
        所属层次：业务处理层
     -->impl:
             基础service实现类
             存放处理系统业务接口的实现类
             所属层次：业务处理层
util:
    基础工具类
    存放系统的通用工具类，提供给【数据访问层】、【业务处理层】、【Web层】来使用

web:

​	-->controller

​		servlet处理类
​      	存放作为系统控制器的Servlet
​      	所属层次：Web层(表现层）
​    -->filter:
​         过滤器处理类
​         存放系统的用到的过滤器(Filter)
​          所属层次：Web层(表现层)
​    -->listener:
​         监听器处理类
​         存放系统的用到的监听器(Listener)
​          所属层次：Web层(表现层)
​    -->UI
​        存放为用户提供用户界面的servlet(UI指的是user interface)
​        所属层次：Web层(表现层)

在开发中如果项目中有一些敏感web资源不想被外界直接访问，那么可以考虑将这些敏感的web资源放到WEB-INF目录下，
这样就可以禁止外界直接通过URL来访问了。



# Log4j的日志输出配置

### 一、 Log4j简介

Log4j有三个主要的组件：

- Loggers(记录器):日志类别和级别;
- Appenders (输出源):日志要输出的地方;
- Layouts(布局):日志以何种形式输出

#### 1.1 Loggers

Loggers组件在此系统中被分为五个级别：DEBUG、INFO、WARN、ERROR和FATAL。这五个级别是有顺序的，DEBUG < INFO < WARN < ERROR < FATAL，分别用来指定这条日志信息的重要程度，明白这一点很重要，
 Log4j有一个规则：**只输出级别不低于设定级别的日志信息**，假设Loggers级别设定为INFO，则INFO、WARN、ERROR和FATAL级别的日志信息都会输出，而级别比INFO低的DEBUG则不会输出。

#### 1.2 Appenders

禁用和使用日志请求只是Log4j的基本功能，Log4j日志系统还提供许多强大的功能，比如允许把日志输出到不同的地方，如控制台（Console）、文件（Files）等，可以根据天数或者文件大小产生新的文件，可以以流的形式发送到其它地方等等。
 **常使用的类如下：**

- org.apache.log4j.ConsoleAppender（控制台）
- org.apache.log4j.FileAppender（文件）
- org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）
- org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）
- org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）

**配置模式：**

```
log4j.appender.appenderName = className
log4j.appender.appenderName.Option1 = value1
…
log4j.appender.appenderName.OptionN = valueN

```

#### 1.3 Layouts

Log4j可以在Appenders的后面附加Layouts来完成这个功能。
 Layouts提供四种日志输出样式，如根据**HTML样式**、**自由指定样式**、**包含日志级别与信息的样式**和**包含日志时间、线程、类别等信息的样式**。
 **常使用的类如下：**

- org.apache.log4j.HTMLLayout（以HTML表格形式布局）
- org.apache.log4j.PatternLayout（可以灵活地指定布局模式）
- org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）
- org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等信息）

**配置模式：**

```
log4j.appender.appenderName.layout =className
log4j.appender.appenderName.layout.Option1 = value1
...
log4j.appender.appenderName.layout.OptionN = valueN

```

### 二、配置详解

在实际应用中，要使Log4j在系统中运行须事先设定配置文件。配置文件事实上也就是对Logger、Appender及Layout进行相应设定。
 Log4j支持两种配置文件格式:

- 一种是XML格式的文件，
- 一种是properties属性文件。

下面以properties属性文件为例介绍log4j.properties的配置。

#### 2.1 配置根Logger：

```
log4j.rootLogger = [ level ] , appenderName1, appenderName2, …
log4j.additivity.org.apache=false：表示Logger不会在父Logger的appender里输出，默认为true。

```

**1. level ：**设定日志记录的最低级别，可设的值有OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者自定义的级别，**Log4j建议只使用中间四个级别**。通过在这里设定级别，您可以控制应用程序中相应级别的日志信息的开关，**比如在这里设定了INFO级别，则应用程序中所有DEBUG级别的日志信息将不会被打印出来。**
 **2. appenderName：**就是指定日志信息要输出到哪里。可以同时指定多个输出目的地，用逗号隔开。
 例如：log4j.rootLogger＝INFO,A1,B2,C3

#### 2.2 配置日志信息输出目的地（appender）：

**appenderName：**自定义appderName，在log4j.rootLogger设置中使用；
 className：可设值如下：

- (1)org.apache.log4j.ConsoleAppender（控制台）
- (2)org.apache.log4j.FileAppender（文件）
- (3)org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）
- (4)org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）
- (5)org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）

##### (1) ConsoleAppender选项

- Threshold=WARN：指定日志信息的最低输出级别，默认为DEBUG。
- ImmediateFlush=true：表示所有消息都会被立即输出，设为false则不输出，默认值是true。
- Target=System.err：默认值是System.out。

##### (2) FileAppender选项

- Threshold=WARN：指定日志信息的最低输出级别，默认为DEBUG。
- ImmediateFlush=true：表示所有消息都会被立即输出，设为false则不输出，默认值是true。
- Append=false：true表示消息增加到指定文件中，false则将消息覆盖指定的文件内容，默认值是true。
- File=D:/logs/logging.log4j：指定消息输出到logging.log4j文件中。

##### (3) DailyRollingFileAppender选项

- Threshold=WARN：指定日志信息的最低输出级别，默认为DEBUG。
- ImmediateFlush=true：表示所有消息都会被立即输出，设为false则不输出，默认值是true。
- Append=false：true表示消息增加到指定文件中，false则将消息覆盖指定的文件内容，默认值是true。
- File=D:/logs/logging.log4j：指定当前消息输出到logging.log4j文件中。
- DatePattern='.'yyyy-MM：每月滚动一次日志文件，即每月产生一个新的日志文件。当前月的日志文件名为logging.log4j，前一个月的日志文件名为logging.log4j.yyyy-MM。
   另外，也可以指定按周、天、时、分等来滚动日志文件，对应的格式如下：

1. '.'yyyy-MM：每月
2. '.'yyyy-ww：每周
3. '.'yyyy-MM-dd：每天
4. '.'yyyy-MM-dd-a：每天两次
5. '.'yyyy-MM-dd-HH：每小时
6. '.'yyyy-MM-dd-HH-mm：每分钟

##### (4) RollingFileAppender选项

- Threshold=WARN：指定日志信息的最低输出级别，默认为DEBUG。
- ImmediateFlush=true：表示所有消息都会被立即输出，设为false则不输出，默认值是true。
- Append=false：true表示消息增加到指定文件中，false则将消息覆盖指定的文件内容，默认值是true。
- File=D:/logs/logging.log4j：指定消息输出到logging.log4j文件中。
- MaxFileSize=100KB：后缀可以是KB, MB 或者GB。在日志文件到达该大小时，将会自动滚动，即将原来的内容移到logging.log4j.1文件中。
- MaxBackupIndex=2：指定可以产生的滚动文件的最大数，例如，设为2则可以产生logging.log4j.1，logging.log4j.2两个滚动文件和一个logging.log4j文件。

#### 2.3 配置日志信息的输出格式（Layout）

```
log4j.appender.appenderName.layout=className

```

**className：可设值如下：**

- (1)org.apache.log4j.HTMLLayout（以HTML表格形式布局）
- (2)org.apache.log4j.PatternLayout（可以灵活地指定布局模式）
- (3)org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）
- (4)org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）

##### (1) HTMLLayout选项

- LocationInfo=true：输出java文件名称和行号，默认值是false。
- Title=My Logging： 默认值是Log4J Log Messages。

##### (2) PatternLayout选项：

ConversionPattern=%m%n：设定以怎样的格式显示消息。
 **格式化符号说明：**

- %p：输出日志信息的优先级，即DEBUG，INFO，WARN，ERROR，FATAL。
- %d：输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，如：%d{yyyy/MM/dd HH:mm:ss,SSS}。
- %r：输出自应用程序启动到输出该log信息耗费的毫秒数。
- %t：输出产生该日志事件的线程名。
- %l：输出日志事件的发生位置，相当于%c.%M(%F:%L)的组合，包括类全名、方法、文件名以及在代码中的行数。例如：test.TestLog4j.main(TestLog4j.java:10)。
- %c：输出日志信息所属的类目，通常就是所在类的全名。
- %M：输出产生日志信息的方法名。
- %F：输出日志消息产生时所在的文件名称。
- %L:：输出代码中的行号。
- %m:：输出代码中指定的具体日志信息。
- %n：输出一个回车换行符，Windows平台为"\r\n"，Unix平台为"\n"。
- %x：输出和当前线程相关联的NDC(嵌套诊断环境)，尤其用到像java servlets这样的多客户多线程的应用中。
- %%：输出一个"%"字符。

另外，还可以在%与格式字符之间加上修饰符来**控制其最小长度、最大长度、和文本的对齐方式**。如：

- 1. c：指定输出category的名称，最小的长度是20，如果category的名称长度小于20的话，默认的情况下右对齐。
- 2)%-20c："-"号表示左对齐。
- 3)%.30c：指定输出category的名称，最大的长度是30，如果category的名称长度大于30的话，就会将左边多出的字符截掉，但小于30的话也不会补空格。

### 附：Log4j比较全面的配置

Log4j配置文件实现了输出到控制台、文件、回滚文件、发送日志邮件、输出到数据库日志表、自定义标签等全套功能。

```
log4j.rootLogger=DEBUG,console,dailyFile,im
log4j.additivity.org.apache=true
# 控制台(console)
log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.ImmediateFlush=true
log4j.appender.console.Target=System.err
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
# 日志文件(logFile)
log4j.appender.logFile=org.apache.log4j.FileAppender
log4j.appender.logFile.Threshold=DEBUG
log4j.appender.logFile.ImmediateFlush=true
log4j.appender.logFile.Append=true
log4j.appender.logFile.File=D:/logs/log.log4j
log4j.appender.logFile.layout=org.apache.log4j.PatternLayout
log4j.appender.logFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
# 回滚文件(rollingFile)
log4j.appender.rollingFile=org.apache.log4j.RollingFileAppender
log4j.appender.rollingFile.Threshold=DEBUG
log4j.appender.rollingFile.ImmediateFlush=true
log4j.appender.rollingFile.Append=true
log4j.appender.rollingFile.File=D:/logs/log.log4j
log4j.appender.rollingFile.MaxFileSize=200KB
log4j.appender.rollingFile.MaxBackupIndex=50
log4j.appender.rollingFile.layout=org.apache.log4j.PatternLayout
log4j.appender.rollingFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
# 定期回滚日志文件(dailyFile)
log4j.appender.dailyFile=org.apache.log4j.DailyRollingFileAppender
log4j.appender.dailyFile.Threshold=DEBUG
log4j.appender.dailyFile.ImmediateFlush=true
log4j.appender.dailyFile.Append=true
log4j.appender.dailyFile.File=D:/logs/log.log4j
log4j.appender.dailyFile.DatePattern='.'yyyy-MM-dd
log4j.appender.dailyFile.layout=org.apache.log4j.PatternLayout
log4j.appender.dailyFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
# 应用于socket
log4j.appender.socket=org.apache.log4j.RollingFileAppender
log4j.appender.socket.RemoteHost=localhost
log4j.appender.socket.Port=5001
log4j.appender.socket.LocationInfo=true
# Set up for Log Factor 5
log4j.appender.socket.layout=org.apache.log4j.PatternLayout
log4j.appender.socket.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
# Log Factor 5 Appender
log4j.appender.LF5_APPENDER=org.apache.log4j.lf5.LF5Appender
log4j.appender.LF5_APPENDER.MaxNumberOfRecords=2000
# 发送日志到指定邮件
log4j.appender.mail=org.apache.log4j.net.SMTPAppender
log4j.appender.mail.Threshold=FATAL
log4j.appender.mail.BufferSize=10
log4j.appender.mail.From = xxx@mail.com
log4j.appender.mail.SMTPHost=mail.com
log4j.appender.mail.Subject=Log4J Message
log4j.appender.mail.To= xxx@mail.com
log4j.appender.mail.layout=org.apache.log4j.PatternLayout
log4j.appender.mail.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
# 应用于数据库
log4j.appender.database=org.apache.log4j.jdbc.JDBCAppender
log4j.appender.database.URL=jdbc:mysql://localhost:3306/test
log4j.appender.database.driver=com.mysql.jdbc.Driver
log4j.appender.database.user=root
log4j.appender.database.password=
log4j.appender.database.sql=INSERT INTO LOG4J (Message) VALUES('=[%-5p] %d(%r) --> [%t] %l: %m %x %n')
log4j.appender.database.layout=org.apache.log4j.PatternLayout
log4j.appender.database.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n

# 自定义Appender
log4j.appender.im = net.cybercorlin.util.logger.appender.IMAppender
log4j.appender.im.host = mail.cybercorlin.net
log4j.appender.im.username = username
log4j.appender.im.password = password
log4j.appender.im.recipient = corlin@cybercorlin.net
log4j.appender.im.layout=org.apache.log4j.PatternLayout
log4j.appender.im.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n

```

