<%--
  Created by IntelliJ IDEA.
  User: HW
  Date: 2020/9/8
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>火星博客</title>
    <script type="text/javascript">
        function doLogout(){
            //访问LogoutServlet注销当前登录的用户
            window.location.href="${pageContext.request.contextPath}/LogoutServlet";
        }
    </script>
    <link href="static/css/base.css" rel="stylesheet">
    <link href="static/css/index.css" rel="stylesheet">
    <link href="static/css/m.css" rel="stylesheet">
    <script src="static/js/jquery.min.js" type="text/javascript"></script>
    <script src="static/js/jquery.easyfader.min.js"></script>
    <script src="static/js/scrollReveal.js"></script>
    <script src="static/js/common.js"></script>
</head>
<body style="background:#756fd9">
<header>
    <!--menu begin-->
    <div class="menu">
        <nav class="nav" id="topnav">
            <h1 class="logo"><a href="persional.jsp">HW博客</a></h1>
            <li><a href="mainPage.jsp">火网首页</a> </li>
            <li><a href="persionalInform.jsp">火星论坛</a> </li>
            <li><a href="manageBlog.jsp">火星资源库</a></li>
            <li><a href="writeBlog.jsp">火网中心</a> </li>
            <!--search begin-->
            <div id="search_bar" class="search_bar">
                <form  id="searchform" action="search.jsp" method="post" name="searchform">
                    <input type="text" name="name" value=" ">
                    <input type="submit" name="Submit" value="搜索" />
                    <span class="search_ico"></span>
                </form>
            </div>
            <!--search end-->

            <!--personal center begin-->
            <div class="">
                <c:if test="${user==null}">
                    <a href="${pageContext.request.contextPath}/RegisterUIServlet" target="_blank">注册</a>
                    <a href="${pageContext.request.contextPath}/LoginUIServlet">登陆</a>
                </c:if>
                <c:if test="${user!=null}">
                    欢迎您：${user.userName}进入HW的网站
                    <div class="about">
                        <p class="avatar">
                            <a href="persionalInform.jsp" ><img src="images/" alt=""></a>
                        </p>
                        <p class="abname"><a>${user.userName}</a></p>
                    </div>
                    <input type="button" value="退出登陆" onclick="doLogout()">
                </c:if>
            </div>
            <!--personal center end-->
        </nav>
    </div>
    <!--menu end-->
</header>

<article>
    <div class="picsbox">
        <!--slideshow begin-->
        <div class="banner">
            <div id="banner" class="fader">
                <li class="slide" ><a href="/" target="_blank">
                    <img src="static/images/banner03.jpg"><span class="imginfo">即以背影赢了天下，为何回头乱了芳华</span></a>
                </li>
                <div class="fader_controls">
                    <div class="page prev" data-target="prev">&lsaquo;</div>
                    <div class="page next" data-target="next">&rsaquo;</div>
                    <ul class="pager_list"></ul>
                </div>
            </div>
        </div>
        <!--slideshow end-->
        <div class="toppic">
            <li>
                <a href="/" target="_blank"> <i><img src="static/images/toppic01.jpg"></i>
                    <h2>别让这些闹心的套路，毁了你的网页设计!</h2>
                    <span>学无止境</span> </a>
            </li>
        </div>
    </div>

    <div class="blank"></div>

    <!--blogsbox begin-->
    <div class="blogsbox">
        <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
            <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
            <span class="blogpic"><a href="/" title=""><img src="static/images/toppic01.jpg" alt=""></a></span>
            <p class="blogtext">如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... </p>
            <div class="bloginfo">
                <ul>
                    <li class="author"><a href="/">杨青</a></li>
                    <li class="lmname"><a href="/">学无止境</a></li>
                    <li class="timer">2018-5-13</li>
                    <li class="view"><span>34567</span>已阅读</li>
                    <li class="like">9999</li>
                </ul>
            </div>
        </div>
    </div>
    <!--blogsbox end-->

    <div class="sidebar">
        <div class="zhuanti">
            <h2 class="hometitle">特别推荐</h2>
            <ul>
                <li> <i><img src="static/images/banner03.jpg"></i>
                    <p>帝国cms调用方法 <span><a href="/">阅读</a></span> </p>
                </li>
            </ul>
        </div>
        <div class="tuijian">
            <h2 class="hometitle">推荐文章</h2>
            <ul class="tjpic">
                <i><img src="static/images/toppic01.jpg"></i>
                <p><a href="/">别让这些闹心的套路，毁了你的网页设计</a></p>
            </ul>
            <ul class="sidenews">
                <li> <i><img src="static/images/toppic01.jpg"></i>
                    <p><a href="/">别让这些闹心的套路，毁了你的网页设计</a></p>
                    <span>2018-05-13</span> </li>
            </ul>
        </div>

        <div class="cloud">
            <h2 class="hometitle">标签云</h2>
            <ul>
                <a href="/">陌上花开</a> <a href="/">校园生活</a> <a href="/">html5</a> <a href="/">SumSung</a> <a href="/">青春</a> <a href="/">温暖</a> <a href="/">阳光</a> <a href="/">三星</a><a href="/">索尼</a> <a href="/">华维荣耀</a> <a href="/">三星</a> <a href="/">索尼</a>
            </ul>
        </div>

        <div class="links">
            <h2 class="hometitle">友情链接</h2>
            <ul>
                <li><a href="http://www.yangqq.com" target="_blank">HW博客</a></li>
                <li><a href="http://www.yangqq.com" target="_blank">D设计师博客</a></li>
                <li><a href="http://www.yangqq.com" target="_blank">优秀个人博客</a></li>
            </ul>
        </div>
    </div>

</article>

<footer>
    <p><a>HW个人博客</a></p>
</footer>
<a href="#" class="cd-top">Top</a>

</body>
</html>
