<%--
  Created by IntelliJ IDEA.
  User: HW
  Date: 2020/11/1
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HW博客</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/base.css" rel="stylesheet">
    <link href="css/person.css" rel="stylesheet">
    <script type="text/javascript" src="js/main.js" ></script>
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
                <li><a href="#">火网中心</a>
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
                <a class="writeBlog" href="writeBlog.jsp">创作中心</a>
                <div class="about">
                    <c:if test="${user!=null}">
                        <ul class="personal_nav" id="">
                            <li><a href="persionalInform.jsp" ><img class="personal_image" src="images/avatar.jpg" alt=""></a>
                                <ul class="personal_sub_nav" id="personal_nav">
                                    <li class=""><a href="#">个人中心</a></li>
                                    <li class="personal_sub_nav_splid"><a href="#">我的关注</a></li>
                                    <li class=""><a href="#">我的收藏</a></li>
                                    <li class="personal_sub_nav_splid"><a href="#">退出登录</a></li>
                                </ul>
                            </li>
                        </ul>
                    </c:if>
                    <c:if test="${user==null}">
                        <a class="logandregist" href="${pageContext.request.contextPath}/RegisterUIServlet" target="_blank">注册/登陆</a>
                    </c:if>
                </div>
            </div>
            <!--personal center end-->
        </nav>
    </div>
    <!--menu end-->
</header>
<article>
    <div class="person_menu">
        <img class="personal_ico" src="images/avatar.jpg" alt="">
        <ul class="person_nav">
            <li class=""><a href="">我的信息</a></li>
            <li class="personal_sub_nav_splid"><a href="">我的收藏</a></li>
            <li class=""><a href="">我的关注</a></li>
            <li class="personal_sub_nav_splid"><a href="">我的博客</a></li>
            <li class=""><a href="">我的书架</a></li>
            <li class="personal_sub_nav_splid"><a href="">我的论坛</a></li>
            <li class=""><a href="">我的问答</a></li>
            <li class="personal_sub_nav_splid"><a href="">我的下载</a></li>
            <li class=""><a href="">我的资源</a></li>
        </ul>
    </div>
    <div class="person_show">
        <div class="person_context" id="person_context">
            <form action="" method="post" id="form1" name="form1">
            </form>
        </div>
    </div>
</article>
<footer>
    <p><a>HW个人博客          版权所有　© 火星网民</a></p>
</footer>

</body>
</html>

