<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HW
  Date: 2020/9/8
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>火星博客登录</title>
    <c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
    <link href="${path}/static/css/base.css" rel="stylesheet">
    <link href="${path}/static/css/login.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/static/js/base.js" ></script>
</head>
<body>
<header>
    <nav class="nav" id="topnav">
        <div class="logo"><a href="persional.jsp">HW博客<img src=""></a></div>
        <!--list begin-->
        <ul class="menu_nav_list" id="menu_nav_list">
            <li><a href="mainPage.jsp">火网首页</a> </li>
            <li><a href="persionalInform.jsp">火星论坛</a> </li>
            <li><a href="manageBlog.jsp">火星资源</a></li>
            <li><a href="writeBlog.jsp">火网中心</a>
                <ul class="sub_nav" id="sub_nav">
                    <li><a href="share.html">个人博客</a></li>
                    <li><a href="share.html">创作中心</a></li>
                    <li><a href="share.html">收藏</a></li>
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
            <c:if test="${user==null}">
                <a class="logandregist" href="${path}/RegisterUIServlet" target="_blank">注册/登陆</a>
            </c:if>
            <c:if test="${user!=null}">
                <div class="about">
                    <a href="persionalInform.jsp" ><img class="personal_image" src="${path}/static/images/<c:out value='${user.image}' />" alt=""></a>
                </div>
            </c:if>
        </div>
        <!--personal center end-->
    </nav>
</header>
<article>
    <div class="main">
        <div class="left"><p></p></div>
        <div class="right">
            <div class="choose">
                <input class="choose_login choose_btn" id="choose_login" type="button" value="登录" onclick="login();"/>
                <input class="choose_regist choose_btn" id="choose_regist" type="button" value="注册" onclick="register();"/>
            </div>
            <div class="login panel" id="login">
                <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
                    <span>登录</span>
                    <input type="text" name="userName" class="input name" placeholder="请输入用户名"/>
                    <input type="text" name="userPassWord" class="input password" placeholder="请输入密码"/>
                    <input type="text" name="" class="input code" placeholder="请输入验证码"/>
                    <input type="button" name="" class="input btn" id="login_btn" onclick="" value="登录"/>
                </form>
            </div>

            <div class="regist panel" id="regist">
                <form action="${pageContext.request.contextPath}/RegisterUIServlet" method="post">
                    <span>注册</span>
                    <input type="text" name="userEmail" class="input email" placeholder="请输入邮箱"/>
                    <input type="text" name="userName" class="input name" placeholder="请输入用户名"/>
                    <input type="text" name="userPassWord" class="input password" placeholder="请输入密码"/>
                    <input type="text" name="confirmPwd" class="input cofpassword" placeholder="请确认密码"/>
                    <input type="button" class="input btn" id="regist_btn" onclick="" value="注册"/>
                </form>
            </div>

        </div>
    </div>
</article>
<footer>
    <p><a>HW个人博客  版权所有　© 火星网民</a></p>
</footer>
</body>
</html>

