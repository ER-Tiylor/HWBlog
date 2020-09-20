<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HW
  Date: 2020/9/10
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<input type="hidden" value="<c:out value="" />">
    <c:forEach items="${message}" var="row">
        <c:out value="${row}" />
    </c:forEach>
</body>
</html>
