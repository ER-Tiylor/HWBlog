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
</header>
<article>
    <div class="main">
        <div class="left"><p class="saying">晚来天欲雪，能饮一杯无</p></div>
        <div class="right">
            <div class="choose">
                <input class="choose_login choose_btn" id="choose_login" type="button" value="登录" onclick="login();"/>
                <input class="choose_regist choose_btn" id="choose_regist" type="button" value="注册" onclick="register();"/>
            </div>
            <div class="login panel" id="login">
                <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
                    <span class="error"></span>
                    <input type="text" name="userEmail" class="input name" placeholder="请输入邮箱"/>
                    <input type="password" name="userPassWord" class="input password" placeholder="请输入密码"/>
                    <input type="text" name="verCode" class="input code" placeholder="请输入验证码"/><img class="ver_img" id="Ver_login_Image" src="${path}/user/check.jpg" οnclick="refresh()">
                    <div class="login_notice">没有账号？<a href="javascript:register();">去注册</a></div>
                    <input type="submit" name="" class="input btn login_btn" id="login_btn" onclick="" value="登录"/>
                </form>
            </div>

            <div class="regist panel" id="regist">
                <form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
                    <span class="error" ></span>
                    <input type="text" name="userEmail" class="input email" placeholder="请输入邮箱"/>
                    <input type="password" name="userPassWord" class="input password" placeholder="请输入密码"/>
                    <input type="password" name="confirmPwd" class="input cofpassword" placeholder="请确认密码"/>
                    <input type="text" name="verCode" class="input code" placeholder="请输入验证码"/><img class="ver_img" id="Ver_regist_Image" src="${path}/user/check.jpg" οnclick="refresh()">
                    <div class="regist_notice">
                        <input type="checkbox" name="agreement" class="agreement" id="agreement" onchange="checkboxOnclick(this)" /><a href="#">同意协议</a>
                        <div class="goLogin">已有账号？<a href="javascript:login();">去登录</a></div>
                    </div>
                    <input type="submit" class="input btn regist_btn" id="regist_btn" onclick="" disabled="disabled"  value="注册"/>
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

