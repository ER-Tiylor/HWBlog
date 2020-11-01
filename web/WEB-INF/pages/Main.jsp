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
    <c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${path}/static/css/base.css" rel="stylesheet">
    <link href="${path}/static/css/main.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/static/js/base.js" ></script>
</head>
<body>
    <header>
        <!--menu begin-->
        <div class="menu">
            <nav class="nav" id="topnav">
                <div class="logo"><a href="persional.jsp">HW博客<img src=""></a></div>
                <!--list begin-->
                <ul class="menu_nav_list" id="menu_nav_list">
                    <li><a href="#">火网首页</a> </li>
                    <li><a href="#">火星论坛</a> </li>
                    <li><a href="#">火星资源</a></li>
                    <li><a href="${path}/PersonalServlet">火网中心</a>
                        <ul class="sub_nav" id="sub_nav">
                            <li><a href="#">个人博客</a></li>
                            <li><a href="#">创作中心</a></li>
                            <li><a href="#">收藏</a></li>
                        </ul>
                    </li>
                </ul>
                <!--list end-->

                <!--search begin-->
                <div id="search_bar" class="search_bar">
                    <form  id="searchform" action="search.jsp" method="post" name="searchform">
                        <input class="input_search" placeholder="想搜点什么呢..." type="text" name="keyboard" id="keyboard" />
                        <span class="search_ico"></span>
                    </form>
                </div>
                <!--search end-->

                <!--personal center begin-->
                <div class="personal_center">
                    <a class="writeBlog" href="#">创作中心</a>
                    <div class="about">
                        <c:if test="${user!=null}">
                            <ul class="personal_nav" id="">
                                <li><a href="persionalInform.jsp" ><img class="personal_image" src="images/avatar.jpg' />" alt=""></a>
                                    <ul class="personal_sub_nav" id="personal_nav">
                                        <li><a href="#">个人中心</a></li>
                                        <li class="personal_sub_nav_splid"><a href="#">我的关注</a></li>
                                        <li><a href="#">我的收藏</a></li>
                                        <li class="personal_sub_nav_splid"><a href="#">退出登录</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </c:if>
                        <c:if test="${user==null}">
                            <a class="logandregist" href="${path}/MainLoginUIServlet" target="_blank">注册/登陆</a>
                        </c:if>
                    </div>
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
                    <li class="slide" ><a href="#" target="_blank">
                        <img src="${path}/static/images/banner01.jpg"><span class="imginfo">即以背影赢了天下，为何回头乱了芳华</span></a>
                    </li>
                    <div class="fader_controls">
                        <div class="page prev" data-target="prev">&lsaquo;</div>
                        <div class="page next" data-target="next">&rsaquo;</div>
                    </div>
                </div>
            </div>
            <!--slideshow end-->
            <div class="toppic">
                <h3>话题榜</h3><hr />
                <ul class="toppic_list">
                    <span class="toppic_rank">1</span>
                    <li class="toppic_info">
                        <div class="toppic_title">
                            <a href="#" title="">PHP安装配置</a>
                        </div>
                        <div class="toppic_read">
                            <span class="toppic_auther">HW</span>
                            <span class="img_view"></span>
                            <span class="toppic_view">2564</span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <div class="blank"></div>

        <!--blogsbox begin-->
        <div class="blogsbox">
            <div class="blogs">
                <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
                <span class="blogpic"><a href="/" title=""><img src="${path}/static/images/avatar.jpg" alt=""></a></span>
                <div class="bloginfo">
                    <p class="blogtext"><a href="/" target="_blank">我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！</a> </p>
                    <ul>
                        <li class="author"><a href="/">火网</a></li>
                        <li class="timer">2018-5-13</li>
                        <li class="view"><span>34567</span>已阅读</li>
                        <li class="comment"><a href="/">23</a></li>
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
                    <li> <i><img src=""></i>
                        <p>帝国cms调用方法 <span><a href="/">阅读</a></span> </p>
                    </li>
                </ul>
            </div>
            <div class="tuijian">
                <h2 class="hometitle">推荐文章</h2>
                <ul class="tjpic">
                    <i><img src=""></i>
                    <p><a href="/">别让这些闹心的套路，毁了你的网页设计</a></p>
                </ul>
                <ul class="sidenews">
                    <li> <i><img src=""></i>
                        <p><a href="/">别让这些闹心的套路，毁了你的网页设计</a></p>
                        <span>2018-05-13</span> </li>
                </ul>
            </div>

        </div>

    </article>

    <footer>
        <p><a>HW个人博客  版权所有　© 火星网民</a></p>
    </footer>
    <a href="#" class="cd-top">Top</a>
</body>
</html>

