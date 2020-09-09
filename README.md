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