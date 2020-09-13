<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HW
  Date: 2020/9/8
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
    用户名：<input type="text" name="userName"><c:out value="${message.errors.userName}"/><br/>
    密码：<input type="password" name="userPassWord"><c:out value="${message.errors.userPassWord}"/><br/>
    <input type="submit" value="登陆">
</form>
</body>
</html>
