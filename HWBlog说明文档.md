

# HWBlog开发说明文档

## 绪论

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">之前没有系统的学习过Javaweb的相关知识，也没有上手实战过。虽然之前在校期间也有做过类似的博客系统，但是没有系统的完成过，只是单纯的实现了注册登录管理博客的几个功能，创建项目也是杂乱无章，对于后期的维护造成巨大的困难，现在看之前写的代码，哎，一言难尽。对于这个项目的初衷，我是抱着学习和实践的态度，尽自己最大的努力，完整的做完这个项目，因为自己在这个方面还是不甚了解，所以遇到很多的问题还得去哔站看视频学习或者百度谷歌，在CSDN和博客园这些网站上有许多问题的答案，我也只能边开发边学习。这个项目是用Servlet+JSP+JavaBean（MVC）的开发模式,当把所有初级设想的功能实现之后，也就完成了第一阶段的开发和学习，随后的是项目的迁移和改造，我将使用框架技术做项目的升级，不过也是后话了。<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">关于本说明书的内容，里面会把我做这个博客的详细步骤全部列出来，其中包括需求规格说明书，还有我的学习笔记的记录，我会把所有设计到的相关内容尽量的详细列出，也是我通过大量的时间整理出来的一些内容，涉及到数据库、软件工程等多门学科的内容，也是为了完整的开发这各项目所做的准备吧！</p>
<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">在这之前，还是想把Javaweb的发展历程了解一下：（详细的历程可以参考：<a href="https://www.cnblogs.com/whx7762/p/7723508.html">java web的发展历史</a>）</p>

- 1、Servlet的出现
- 2、Jsp的出现
- 3、倡导了MVC思想的Servlet版本1.2出现——JSP+Servlet+JavaBean
- 4、框架阶段 
  - 4.1、Struts的出现
  - 4.2、Spring的出现
  - 4.3、SpringMVC的出现

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">对于JSP+Servlet+JavaBean开发模式(MVC)，我自己了解到的不是很多，参考了一些博客，写的很详细，这里也就不在多赘述了。<a href="https://blog.csdn.net/ayangann915/article/details/89284633">JavaWeb的MVC模式解释</a></p>
![img](https://img-blog.csdn.net/20140520211112390?%3C/p%3E%3Cp%3Ewatermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaHlta2luZw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

![img](https://img-blog.csdn.net/20140520211204203?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaHlta2luZw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)



### 1.创建项目

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">了解了MVC开发模式，那就开始创建项目愉快的搬代码了。本项目采用浏览器/服务器（B/S）架构；项目的开发需要符合一定的规范，创建的项目要有一个良好的结构，层次要分明，各模块之间的功能职责要清晰明了，以便于项目的开发和后期的维护。之前看了一篇博客，里面有写到如何在MVC模式搭建javaweb项目，介绍的很全面，我的项目也是参考这篇博客创建的目录结构：<a href="https://blog.csdn.net/afanti222/article/details/79487167">JavaWeb实现用户登录注册功能实例</a>。下面详细介绍项目创建和环境配置：</p>
#### (1).开发环境、工具与依赖的jar包

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">需要的工具都在百度盘里：</p>
* 使用的IDE：idea2019.2.4

* 使用的JDK：1.8.0_191

* 数据库：MySql5.7

* 依赖的jar包：

  | 序号 |            jar包名称            | 描述                                   |
  | ---- | :-----------------------------: | -------------------------------------- |
  | 1    |       **dom4j-1.6.1.jar**       | dom4j用于操作XML文件                   |
  | 2    |    **jaxen-1.1-beta-6.jar**     | 用于解析XPath表达式                    |
  | 3    | **commons-beanutils-1.8.0.jar** | 工具类，用于处理bean对象               |
  | 4    |     **commons-logging.jar**     | commons-beanutils-1.8.0.jar的依赖jar包 |
  | 5    |          **jstl.jar**           | jstl标签库和EL表达式依赖包             |
  | 6    |        **standard.jar**         | jstl标签库和EL表达式依赖包             |
  | 7    |      **log4j-1.2.17.jar**       | 格式化日志打印                         |
  
  1

#### (2).创建项目及配置

创建项目配置环境的步骤：

* 打开idea，点击创建project       

  ![1601088212089](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601088212089.png)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       

* 选择java版本，选择tomcat的版本

  ![1601088562297](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601088562297.png)

  ![1601088923378](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601088923378.png)

* 选择模板点击下一步

  ![1601089156042](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601089156042.png)

* 写上自己的项目名称，点击完成

  ![1601089354299](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601089354299.png)

* 创建好的项目中需要添加一些文件，在web/WEB-INF下创建两个文件夹classes和lib，classes用来存放编译后输出的文件，lib用于存放第三方jar包，将之前的jar包拷到lib下。WEB-INF目录是安全目录，该目录下面的文件不能直接访问，需要在web.xml配置。pages下面放jsp页面。static目录下面存放js、css、images、等静态资源。

  ![1601090087238](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601090087238.png)

* File -> Project Structure (快捷键：Ctrl + Shift + Alt + S) -> 选择Module ：第5步选择自己刚创建的classes文件夹，点击apply，先不点ok。

  ![1601090508132](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601090508132.png)

* 接着选择Dependencies ->  将Module SDK选择为1.8 -> 点击右边的“+”号  -> 选择1 “Jars or Directories”

  ![1601090890138](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601090890138.png)

* 勾选刚才导入的lib目录，点击ok

  ![1601090971127](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601090971127.png)

* 接下来配置tomcat，选择Edit configurations，或者打开菜单Run -> 选择Edit Configuration

  ![1601091123624](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601091123624.png)

* 在创建项目时，选择了tomcat容器，这里只需要简单配置一些内容：配置完成后点击ok。

  ![1601091764287](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601091764287.png)

下面是我自己创建的目录结构：

![1600787216605](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1600787216605.png)

![1600787257971](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1600787257971.png)



#### (3).其他配置

log4j的参考配置：log4j.properties的内容

```
log4j.rootLogger=INFO,console,dailyFile
log4j.additivity.org.apache=true

# 控制台(console)
log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Threshold=INFO
log4j.appender.console.ImmediateFlush=true
log4j.appender.console.Target=System.err
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n

# 日志文件(logFile)
log4j.appender.logFile=org.apache.log4j.FileAppender
log4j.appender.logFile.Threshold=INFO
log4j.appender.logFile.ImmediateFlush=true
log4j.appender.logFile.Append=true
log4j.appender.logFile.File=G:/logs/log.log4j
log4j.appender.logFile.layout=org.apache.log4j.PatternLayout
log4j.appender.logFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n

# 回滚文件(rollingFile)
log4j.appender.rollingFile=org.apache.log4j.RollingFileAppender
log4j.appender.rollingFile.Threshold=INFO
log4j.appender.rollingFile.ImmediateFlush=true
log4j.appender.rollingFile.Append=true
log4j.appender.rollingFile.File=G:/logs/log.log4j
log4j.appender.rollingFile.MaxFileSize=200KB
log4j.appender.rollingFile.MaxBackupIndex=50
log4j.appender.rollingFile.layout=org.apache.log4j.PatternLayout
log4j.appender.rollingFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n

# 定期回滚日志文件(dailyFile)
log4j.appender.dailyFile=org.apache.log4j.DailyRollingFileAppender
log4j.appender.dailyFile.Threshold=INFO
log4j.appender.dailyFile.ImmediateFlush=true
log4j.appender.dailyFile.Append=true
log4j.appender.dailyFile.File=G:/logs/log.log4j
log4j.appender.dailyFile.DatePattern='.'yyyy-MM-ww
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
log4j.appender.mail.From = 482125446@qq.com
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

## 自定义Appender
#log4j.appender.im = net.cybercorlin.util.logger.appender.IMAppender
#log4j.appender.im.host = mail.cybercorlin.net
#log4j.appender.im.username = username
#log4j.appender.im.password = password
#log4j.appender.im.recipient = corlin@cybercorlin.net
#log4j.appender.im.layout=org.apache.log4j.PatternLayout
#log4j.appender.im.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n

```

### 2.搭建网站环境





## 一、HWBlog功能概述

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">HWBlog的主体功能模块：（一）博客信息浏览，（二）注册登录模块，（三）个人博客管理模块，（四）留言管理模块；（五）系统管理。</p>
### 1.博客信息浏览模块
<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">博客信息浏览模块主要的功能有两个：1.阅读功能；2.点评功能；用户在非登录状态下，即游客状态只享有对该模块下的阅读功能，用户在登录状态下，对该模块的功能有完全控制。</p>
#### (1)阅读功能：
<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">网站信息展示，用户可博客阅读、查看博客详细信息（包括发布人、发布时间、浏览量、点赞和收藏的数量等）、查看博主相关信息等。</p>
#### (2)点评功能：
<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">该模块还有用户点赞收藏评论，查看评论的功能。</p>
### 2.注册登录模块

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">注册登录模块主要是负责用户的注册、登录、登录状态管理、注销登录状态的功能。用户登录时对登录信心加密再去验证，用户注册时先判断用户是否存在，若存在，提示用户存在，并跳转登录页面。</p>
### 3.个人管理模块

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">个人管理模块包含两个部分：1.个人博客管理；2.用户管理；</p>
#### (1)个人博客管理
<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">用户注册成功后登录系统，就会拥有个人博客管理模块的相关权限。这个模块的主要功能是：博客操作：用户书写博客、保存草稿、发布个人博客、修改个人博客、删除个人博客、文件上传。</p>
#### (2)用户管理

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">用户管理是基于个人模块下的一个独立功能模块，具体的功能有个人信息管理、粉丝管理；个人信息管理是对用户名、密码、头像等一些用户个人信息的修改和管理；还包括收藏夹管理、个人文章类别和标签设置等功能。粉丝管理功能中用户可以查看关注、点赞和收藏用户博客的其他用户。</p>
### 4.留言管理

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">留言系统是一个基础的公共功能模块。留言板功能单独设计为一个功能模块，用户可以留言以及回复留言的擦偶哦，所有登录系统的个人用户，可以对任意发布的文章进行评论，文章的作者可以回复其他用户的评论，管理员可以管理所有文章的评论。</p>
### 5.系统管理

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">该功能模块是针对博客网站的后台管理系统，只有管理员才可以登录，主要功能：网站首页资源更新、网站信息维护、管理用户、管理评论、管理博客、博客类别管理、博客标签管理。</p>
## 二、数据库设计

### 1.数据库设计概述

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">数据库设计是指对于一个给定的应用环境，构造（设计）优化的数据库逻辑模式和物理结构，并据此建立数据库及其应用系统，使之能够有效地存储和管理数据，满足各种用户的应用需求，包括信息管理要求和数据操作要求。</p>
![1601780274442](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601780274442.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(0,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.1：结构和行为分离的设计</div>
**数据库设计的基本步骤：**

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">6个步骤：</p>
* 需求分析：数字字典、全系统中数据项、数据结构、数据流、数据存储的描述
* 概念结构设计：概念模型（E-R图）、数据字典
* 逻辑结构设计：某种关系模型（关系/非关系）
* 物理结构设计：存储安排、存取方式选择、存取路径建立
* 数据库实施：创建数据库模式、装入数据、数据库试运行
* 数据库运行和维护：性能检测、转储/恢复、数据库重组和重构

**数据字典：**

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">数据字典是进行详细的数据收集和数据分析所获得的主要成果，它是关于数据库中数据的描述，即元数据，而不是数据本身。数据字典在需求分析阶段建立，在数据库设计过程中不断的修改、充实、完善的。数据字典通常包含以下部分：</p>
* 数据项：数据项是不可再分的数据单位。

  <p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">数据项描述={数据项名，数据项含义说明，别名，数据类型、长度，取值范围，取值含义，与其他数据项的逻辑关系，数据项之间的联系}</p>

* 数据结构：数据结构反映了数据之间的组合关系。一个数据结构可以由若干数据项组成，也可以由若干数据结构组成，也可以由两者若干混合组成。

  <p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">数据结构描述={数据结构名，含义说明，组成{数据项或数据结构}}</p>

* 数据流：数据流是数据结构在系统内传输的路径。

  <p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">数据流描述={数据流名，说明，数据流来源，数据流去向，组成：{数据结构}，平均流量，高峰期流量}</p>

* 数据存储：数据存储是数据结构停留或保存的地方，也是数据流的来源和去向之一。

  <p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">数据存储描述={数据存储名，说明，编号，输入的数据流，输出的数据流，组成：{数据结构}，数据量，存取频度，存取方式}</p>

* 处理过程：处理过程的具体逻辑一般用判定表或判定树来描述，数据字典中只需要描述处理过程的说明性信息即可。

  <p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">处理过程描述={处理过程名，说明，输入：{数据流}，输出：{数据流}，处理：{简要说明}}</p>

**E-R模型**

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">由P.P.S.Chen提出的E-R模型是用E-R图来描述现实世界的概念模型。</p>
**ISA联系**

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">在使用E-R方法构建一个项目的模型时，经常会遇到某些实体型是某个实体型的子类型。如：研究生和本科生都是学生。本科生is a学生，本科生is a 学生。ISA的一个重要的性质是子类继承了父类的所有属性，子类还可以拥有自己的属性。</p>
![1601806257109](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601806257109.png)

**Part-of联系**

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">即部分联系，表明了某个实体是另外一个实体的一部分。如：汽车和轮胎。汽车的约束是4...4，即一辆车需要4个轮子，轮子的约束是0...1，这样的约束表示非强制参与联系。一个轮子可以装到一个汽车上，也可以没有被安装到任何车辆和独立存在，即一个轮子可以参与联系也可以不参与联系，在E-R图中用非强制参与联系表示非独占Part-of联系。还有一种Part-of联系是独占联系，即整体实体若被破坏，部分实体不能存在。在E-R图中用弱实体类型和识别联系来表示独占联系，如果一个实体型的存在依赖于其他实体存在，则这个实体叫做弱实体型，否则叫做强实体型。</p>
![1601805609551](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601805609551.png)

### 2.数据库概念结构设计

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">将需求分析中得到的用户需求抽象成为信息结构（即概念模型）的过程就是概念结构设计，它是整个数据库设计的关键。</p>
<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">由之前的功能分析，需要的实体关系模式表示：</p>
- 用户：用户ID、用户IP、用户昵称、用户名、用户密码、用户邮箱、用户生日、用户电话号码、用户头像、用户注册时间、用户权限标识、用户描述。
- 博客：博客ID、发布作者ID、发布日期、博客标题、博客内容、博客附件、点赞数量、收藏数量、阅读数量、博客类别、博客标签
- 博客类别：类别ID、分类名称、分类别名、分类描述
- 博客标签：标签ID、标签名称、标签别名、标签描述
- 评论：评论ID、父评论ID、评论博客ID、评论用户ID、评论日期、评论内容、点赞数量
- 用户权限：权限ID、权限描述、权限名称、权限级别

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">实体之间的联系:</p>
* 一个用户可以发表多个博客，一个博客只能由一个用户发表
* 一个用户拥有多种操作权限，一种操作权限可以对应多个不同的用户
* 一个博客对应一种博客类型，一种博客类型可以对应多个不同博客
* 一个用户可以评论多个博客，一个博客可以被多个用户评论
* 一个博客对应多个标签，一个标签可以标识多个博客

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">基本E-R图:</p>
![1601990810168](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601990810168.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.2：用户E-R图</div>
![1601795915984](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601795915984.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.3：博客E-R图</div>
![1601796284813](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601796284813.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.4：博客类别E-R图</div>
![1601796436088](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601796436088.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.5：博客标签E-R图</div>
![1601797910709](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601797910709.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.6：权限E-R图</div>


![1601911611732](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601911611732.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.7：评论E-R图</div>
![1601990893792](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601990893792.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图2.8：整体E-R图:</div>
### 3. 数据库逻辑结构设计

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">概念结构是独立于任何一种数据模型的信息结构，逻辑结构设计的任务是把概念结构设计阶段设计好的基本E-R图转换为与选用数据库管理系统产品所支持的数据模型相符合的逻辑结构。由于使用的是关系数据库，这里是将前面描述的E-R图转换为关系数据模型。下面是转换的一般原则，一个实体型转换为一个关系模式，关系的属性就是实体的属性，关系的码就是属性的码。</p>
* 一个1：1联系可以转换为一个独立的关系模式，也可以与任意一端对应的关系模式合并。
* 一个1：n联系可以转换为一个独立的关系模式，也可以与n端对应的关系模式合并。
* 一个m：n联系转换为一个关系模式，与该联系相连的各实体的码以及联系本身的属性均转换为关系的属性，各实体的码组成关系的码或关系码的一部分。
* 三个或三个以上实体之间的一个多元联系可以转换为一个关系模式。
* 具有相同码的关系模式可合并。

<div style="margin:0 auto;width:;height:;background-color:rgba(0,200,50,0.1);line-height:1.5;text-align:justify;padding:10px;border-radius:10px;padding:10px">建表原则：</br>一对一建表原则：</br><p style="text-indent:2em;">唯一外键对应：假设一对一中的任意的一方为多，在多的一方创建外键指向一的一方的主键，然后将外键设置为唯一。</p><p style="text-indent:2em;">主键对应：一方的主键作为另一方的主键。</p>一对多建表原则：在多的一方创建外键，指向一的一方的主键。</br>多对多建表原则：创建一个中间表，中间表中至少两个字段作为外键，分别指向多对多双方的主键</div>
#### (1).基本的SQL语句

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">注释：采用 "--"(双减号)进行单行注释，注意："--"与注释内容要用空格隔开才会生效。采用 /*…*/进行多行注释</p>
**创建**

```mysql
CREATE TABLE hwblog_test (
	test_id BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
	NAME VARCHAR(20) COMMENT '姓名'
) COMMENT = '测试表';
```

**删除**

drop table xx --xx是数据表的名字

作用：删除内容和定义，释放空间。简单来说就是把整个表去掉.以后要新增数据是不可能的,除非新增一个表。

```mysql
DROP TABLE hwblog_test;
```

delete table xx

作用：也是删除整个表中的数据 表结构不会删除,但是过程是痛苦的(系统一行一行地删,效率较truncate低) 或delete table tb where 条件

删除内容不删除定义，不释放空间。用delete删除 数据，然后添加。可以看到添加之后id标识不连续。

```mysql
delete table hwblog_test;
```

truncate table xx

作用：删除内容、释放空间但不删除定义。与drop不同的是,他只是清空表数据而已,不删除表结构。

truncate 释放空间的体现。truncate table test 后 向test表添加数据,id标识列连续了(体现了truncate删除是释放空间）

插入的字段的id重新从1开始递增 1、2、3.....

```mysql
truncate table hwblog_test;
```



**修改**

```mysql
--修改字段，添加备注
ALTER TABLE `hwblog_test_user`
CHANGE COLUMN `userloginflag` `userloginflag` VARCHAR(20) COMMENT '测试表id';

--添加字段
ALTER TABLE `hwblog_test_user` ADD user_test BIGINT(20) COMMENT '测试';

```



**主键和外键**

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">键所在的表就是主表（父表），外键所在的表就是从表（子表）。</p>
-  主表必须已经存在于数据库中，或者是当前正在创建的表。如果是后一种情况，则主表与从表是同一个表，这样的表称为自参照表，这种结构称为自参照完整性。
-  必须为主表定义主键。
-  主键不能包含空值，但允许在外键中出现空值。也就是说，只要外键的每个非空值出现在指定的主键中，这个外键的内容就是正确的。
-  在主表的表名后面指定列名或列名的组合。这个列或列的组合必须是主表的主键或候选键。
-  外键中列的数目必须和主表的主键中列的数目相同。
-  外键中列的数据类型必须和主表主键中对应列的数据类型相同。

*在 CREATE TABLE 语句中，通过 FOREIGN KEY*

<div style="margin:0 auto;width:;height:;background-color:rgba(0,0,0,0.1);line-height:1.5;text-align:justify;padding:10px"> [CONSTRAINT <外键名>] FOREIGN KEY 字段名 [，字段名2，…]<br>
 REFERENCES <主表名> 主键列1 [，主键列2，…]</div>

**视图**

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">在 SQL 中，视图是基于 SQL 语句的结果集的可视化的表。视图包含行和列，就像一个真实的表。视图中的字段就是来自一个或多个数据库中的真实的表中的字段。我们可以向视图添加 SQL 函数、WHERE 以及 JOIN 语句，我们也可以提交数据，就像这些来自于某个单一的表。注释：数据库的设计和结构不会受到视图中的函数、where 或 join 语句的影响。</p>
**创建基本表**

```mysql
CREATE DATABASE hwblog;
USE hwblog;

CREATE TABLE hwblog_users
(
	user_id	BIGINT(20) NOT NULL PRIMARY KEY,
	user_ip VARCHAR(20) COMMENT '用户IP',
	user_nickname VARCHAR(30) COMMENT '用户昵称',
	user_name VARCHAR(30) COMMENT '用户名',
    user_gender VARCHAR(10) COMMENT '用户性别',
	user_password VARCHAR(30) NOT NULL COMMENT '用户密码',
	user_email VARCHAR(30) NOT NULL COMMENT '用户邮箱',
	user_birthday DATE COMMENT '用户生日',
	user_telphone_number VARCHAR(11) COMMENT '用户电话号码',
	user_icon VARCHAR(255) COMMENT '用户头像',
	user_register_time DATETIME COMMENT '用户注册时间',
	right_id BIGINT(20) COMMENT '用户权限',
	user_introduction TEXT COMMENT '用户介绍',
	CONSTRAINT `hwblog_users_right` FOREIGN KEY (`right_id`) REFERENCES `hwblog_right` (`right_id`)
)COMMENT '用户表';
CREATE TABLE hwblog_blogs
(
	blogs_id BIGINT(20) NOT NULL PRIMARY KEY,
	user_id BIGINT(20) NOT NULL COMMENT '发布用户',
	blogs_date DATE COMMENT '发布日期',
	blogs_title TEXT COMMENT '博客标题',
	blogs_content LONGTEXT COMMENT '博客内容',
	blogs_views BIGINT COMMENT '浏览数量',
	blogs_likes BIGINT COMMENT '点赞数量',
	blogs_comment BIGINT COMMENT '评论数量',
	blogs_files VARCHAR(255) COMMENT '博客附件',
	sort_id BIGINT(20) NOT NULL COMMENT '博客类别',
	CONSTRAINT `hwblog_blogs_user` FOREIGN KEY (`user_id`) REFERENCES `hwblog_users` (`user_id`),
	CONSTRAINT `hwblog_blogs_sort` FOREIGN KEY (`sort_id`) REFERENCES `hwblog_sort` (`sort_id`)
)COMMENT '博客表';
CREATE TABLE hwblog_comments
(
	comments_id BIGINT(20) NOT NULL PRIMARY KEY,
	parent_comments_id BIGINT(20) COMMENT '父评论ID',
	user_id	BIGINT(20) NOT NULL COMMENT '发评用户',
	blogs_id BIGINT(20) NOT NULL COMMENT '被评文章',
	comments_likes BIGINT COMMENT '获赞数',
	comments_date DATE COMMENT '评论日期',
	comments_content TEXT COMMENT '评论内容',
	CONSTRAINT `hwblog_comments_user` FOREIGN KEY (`user_id`) REFERENCES `hwblog_users` (`user_id`),
	CONSTRAINT `hwblog_comments_blog` FOREIGN KEY (`blogs_id`) REFERENCES `hwblog_blogs` (`blogs_id`)
)COMMENT '评论表';
CREATE TABLE hwblog_right
(
	right_id BIGINT(20) NOT NULL PRIMARY KEY,
	right_name VARCHAR(20) COMMENT '权限名称',
	right_rank VARCHAR(20) COMMENT '权限等级',
	right_description TEXT COMMENT '权限描述'
)COMMENT '权限表';
CREATE TABLE hwblog_sort
(
	sort_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	sort_name VARCHAR(20) COMMENT '类别名称',
	sort_nickname VARCHAR(20) COMMENT '类别别名',
	sort_description TEXT COMMENT '类别描述'
)COMMENT '类别表';
CREATE TABLE hwblog_label
(
	label_id BIGINT(20) NOT NULL PRIMARY KEY,
	label_name VARCHAR(20) COMMENT '标签名称',
	label_nickname VARCHAR(20) COMMENT '标签别名',
	label_description TEXT COMMENT '标签描述'
)COMMENT '标签表';
CREATE TABLE hwblog_set_label
(
	label_id BIGINT(20) NOT NULL,
	blogs_id BIGINT(20) NOT NULL,
	PRIMARY KEY (`label_id`,`blogs_id`)
)COMMENT '设置标签';

```



**创建视图**

```sql
create 
```





#### (2).数据库逻辑模型

博客表：

![1601985117179](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601985117179.png)

评论表：

![1601985157591](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601985157591.png)

用户表：

![1601985675976](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601985675976.png)

标签表：

![1601985415078](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601985415078.png)

类别表：

![1601985649213](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601985649213.png)

权限表：

![1601985534491](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601985534491.png)

设置标签表：

![1601985622797](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1601985622797.png)



### 4.物理结构设计

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">数据库在物理设备上的存储结构与存取方式称为数据库的物理结构，它依赖于选定的数据库管理系统。为了一个给定的逻辑数据模型选取一个最合适应用要求的物理结构的过程，就是数据库的物理设计。数据库的物理设计通常分为两部：</p>
* 确定数据库的物理结构，在关系数据库中主要指存取方式和存取结构。
* 对物理结构进行评价，评价的重点是时间和空间效率。

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">不同的数据库产品所提供的物理环境、存取方式和存储结构有很大的差别，能供设计人员使用的设计变量、参数范围也不相同，因此，没有通用的物理设计方法可遵循，只能给出一般的设计内容和原则。希望设计优化的物理数据库结构，使得在数据库上运行的各种事务响应时间少、存取空间利用率高、事务吞吐率大。首先对运行的事务进行详细分析，获得选择物理数据库设计多需要的参数；其次，要充分了解所用关系数据库管理系统的内部特征，特别是系统提供的存取方法和存储结构。</p>
对于数据库的查询事务，需要的到如下的信息：

* 查询的关系
* 查询条件所涉及的属性
* 连接条件所涉及的属性
* 查询的投影属性

对于数据库的更新事务，需要得到如下信息：

* 被更新的关系
* 每个关系上的更新操作条件所涉及的属性
* 修改操作要改变的属性值

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">通常关系数据库物理设计的内容主要包括为关系模式选择存取方式，以及设计关系、索引等数据库文件的物理存储结构。</p>
## 三、详细功能设计

### 1.异常处理



#### (1) Dao层异常处理

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">在实现 DAO 模式时，考虑以下问题：</p>

- DAO 的公共接口中的方法是否抛出检查过的异常？
- 如果是的话，抛出何种检查过的异常？
- 在 DAO 实现类中如何处理异常？

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">在使用 DAO 模式的过程中，我们的小组开发了一些处理异常的原则。遵从这些原则可以极大地改进您的 DAO：
    DAO 方法应该抛出有意义的异常。</p>

- DAO 方法不应该抛出 java.lang.Exception 。 java.lang.Exception 太一般化了。它不传递关于底层问题的任何信息。 
- DAO 方法不应该抛出 java.sql.SQLException 。SQLException 是一个低级别的 JDBC 异常。一个 DAO 应该力争封装 JDBC 而不是将 JDBC 公开给应用程序的其余部分。 
- 只有在可以合理地预期调用者可以处理异常时，DAO 接口中的方法才应该抛出检查过的异常。如果调用者不能以有意义的方式处理这个异常，那么考虑抛出一个未检查的(运行时)异常。
- 如果数据访问代码捕获了一个异常，不要忽略它。忽略捕获的异常的 DAO 是很难进行故障诊断的。
  使用链接的异常将低级别的异常转化为高级别的异常。
- 考虑定义标准 DAO 异常类。Spring Framework (参阅 参考资料)提供了很好的一套预定义的 DAO 异常类。

#### (2) Service层的异常处理

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">service层捕获异常，并抛出自定义unchecked异常，异常中不定义状态码：checked异常默认情况事务不会回滚</p>

####  (3) Controller 层的异常处理

<p style="font-size=:18px;text-indent:2em;color:grey;text-align:justify;">controller层捕获异常，并抛出自定义异常，异常类中定义需要返回的HTTP状态码：API文档一眼就可以明确所有的返回码</p>

### 2.登录注册模块功能实现



### 3.个人管理模块功能实现



### 4.博客浏览模块功能实现



### 5.留言模块功能实现



### 6.管理员后台维护功能模块





## 四、界面设计





## 五、遇到的问题

### 1.如何处理异常

最好的用法是不是应该在**dao**层抛出**Exception**，**service**层catch之后throw出新的自定义异常**CustomizeException**，给相应异常信息加上描述。controller就直接返回异常中的code和message给前台。

1、dao层不捕获异常、不抛出异常：spring框架将底层的数据库checked异常封装成unchecked异常了

2、service层捕获异常，并抛出自定义unchecked异常，异常中不定义状态码：checked异常默认情况事务不会回滚

3、controller层捕获异常，并抛出自定义异常，异常类中定义需要返回的HTTP状态码：API文档一眼就可以明确所有的返回码

4、exceptionHandler中统一处理所有异常

### 1.如何保存用户登录信息

session、redius

### 2.数据库如何存储博客内容

百度的得到的结果是：FCKedit+Mysql Text字段就搞定

论坛<a href="https://bbs.csdn.net/topics/290010652">我想写一个博客，用mysql数据库，那么用来保存博客内容的字段用什么类型好呢？</a>



## 附录：

### 1.异常处理机制

什么样的异常应该捕获，什么样的异常应该抛出？

* 如果开发的系统正式上线运营，而这时系统里的某些异常可能导致服务器down掉或者有影响，就应该对异常进行捕获处理。

* 在该throw的时候你catch了，那么它上一层的方法原本需要遇异常就要停止的，你再里面就已经catch了，那么它就不会停止运行。同理，catch的时候你throw了，而上一层的方法并不需要你throw的这个异常，这就是底层方法的不负责了，这样可能导致上层方法混乱。

* 异常要抛到最三层结构的最高层，然后输出，并且处理，这样你的程序才健壮。

* 个人觉得如果你知道应该出现这个异常应该怎么处理，就应该捕获，捕获处理之后还可以再次抛出，看上层是否需要了；如果你不知道该如何处理这个异常，那么捕获也是没用，捕到了也是不知道如何处理，还得抛出去，否则异常就丢了。

![1602055851822](C:\Users\HW\AppData\Roaming\Typora\typora-user-images\1602055851822.png)

<div style="border-radius:20px;width:250px;height:40px;background-color:rgba(255,0,0,0.1);line-height:40px;text-align:center;margin:0 auto;">图6.1：异常图:</div>

#### (1) Error（错误）：

是程序无法处理的，指与虚拟机相关的问题（比如：系统崩溃、虚拟机错误）。这些错误无法恢复或者捕获

#### (2) Exception（异常）：

是程序本身可处理的。而异常又分为两大类：Checked异常和Runtime异常（运行时异常）。

#### (3) **五大关键字详解：**

**try：**

<div style="margin:0 auto;width:;height:;background-color:rgba(0,200,50,0.1);line-height:1.5;text-align:justify;padding:10px;border-radius:10px;padding:10px">
作用：里面放置可能引发异常的代码；</br>
特点：在try里面声明的变量是代码块内的局部变量，只在try块内有效，catch块也不能访问该变量。变量不是指物理资源</div>

**catch：**

<div style="margin:0 auto;width:;height:;background-color:rgba(0,200,50,0.1);line-height:1.5;text-align:justify;padding:10px;border-radius:10px;padding:10px">
    作用：用于处理某一类型的代码块</div>

**finally:**

<div style="margin:0 auto;width:;height:;background-color:rgba(0,200,50,0.1);line-height:1.5;text-align:justify;padding:10px;border-radius:10px;padding:10px">作用：用于回收在try块打开的物理资源，异常机制保证finally会被执行(物理资源：如数据库连接、网络连接和磁盘文件等);</br>
 特点：1.即使try和catch有return语句也会执行,但是如果try和catch有System.exit(1)语句来退出虚拟机，就不会执行finally里面的语句; 2.不要在其中使用return或throw等导致方法终止的语句,否则会导致很多奇怪的情况</div>

Java垃圾回收机制不会回收任何物理资源，回收机制只回收堆内存中的对象所占用的内存。所以要在finally去回收

**throw**：

<div style="margin:0 auto;width:;height:;background-color:rgba(0,200,50,0.1);line-height:1.5;text-align:justify;padding:10px;border-radius:10px;padding:10px">作用：用于抛出一个实际异常,程序自行抛出异常。可以单独作为语句使用，抛出一个具体的异常对象；</br>
注意：可以单独使用，抛出的不是异常类，而是一个异常实例，且每次只能抛出一个异常实例！！是一个实例！。</div>

**throws**：

<div style="margin:0 auto;width:;height:;background-color:rgba(0,200,50,0.1);line-height:1.5;text-align:justify;padding:10px;border-radius:10px;padding:10px">作用：在方法签名中使用，用于声明该方法可能抛出的异常；</br>
原理思路：当前方法不知道怎么处理这一类型的异常，需要交由上一级调用者去处理；</br>
规则：子类方法声明抛出的异常类型应该是父类方法声明抛出的异常类型的子类或者与之相同。子类方法声明抛出的异常不允许比父类方法声明抛出的异常大。</div>



## 参考文章

[1]<a href="https://blog.csdn.net/ThinkWon/article/details/102980571"> 程序员写个人技术博客的价值与意义</a>

[2]<a href="https://blog.csdn.net/qq_27574367/article/details/90601946">个人博客系统开发记录</a>

[3]<a href="https://blog.csdn.net/qq_39530754/article/details/85130249">数据字典是什么</a>

[4]<a href="https://blog.csdn.net/Ya_da/article/details/52836287">软件工程 - 个人博客系统 - 可行性分析与需求分析文档</a>

[5]<a href="https://zhuanlan.zhihu.com/p/61123653">14个实用的数据库设计技巧！</a>

[6]<a href="http://blog.sina.com.cn/s/blog_664745a80102v0ri.html">博客内容的存储</a>

[7]<a href="https://blog.csdn.net/chachapaofan/article/details/86571657">个人博客数据库设计</a>

[8]<a href="https://blog.csdn.net/weixin_44538399/article/details/95518325">保存富文本编辑器内容</a>

[9]<a href="https://blog.csdn.net/weixin_42134685/article/details/80454725">百度Ueditor富文本编辑器基础使用配置以及怎样保存图片到磁盘</a>

[10]<a href="https://blog.csdn.net/W211953332/article/details/108179157">分层数据流图简单介绍</a>

[11]<a href="https://blog.csdn.net/mhywoniu/article/details/78587650">SQL 学习笔记</a>

[12]<a href="https://blog.csdn.net/Jack__Frost/article/details/52760930?locationNum=6">Java-异常机制详解以及开发时异常设计的原则要求</a>

[13]<a href="https://blog.csdn.net/yahuvi/article/details/7166237">JAVA WEB 异常处理原则</a>

[14]<a href="https://www.cnblogs.com/andy-zhou/p/5317820.html">Javaweb异常提示信息统一处理</a>

[15]<a href="https://blog.csdn.net/afanti222/article/details/79487167">JavaWeb实现用户登录注册功能实例</a>