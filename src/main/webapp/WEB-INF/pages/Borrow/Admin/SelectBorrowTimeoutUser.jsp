<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 12.07
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>select</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Query文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<table class="table table-hover">
    <form method="post">
        <tr>
            <td align="center" colspan="4">
                <h1>
                    书籍《${borrows.get(0).borrowBookName}》借阅超时表
                </h1>
            </td>
        </tr>
        <tr>
            <td align="center">账户名称</td>
            <td align="center">借阅时间</td>
            <td align="center">应归还时间</td>
        </tr>
        <c:forEach items="${borrows}" var="borrow">
            <tr>
                <td align="center">${borrow.borrowUserName}</td>
                <td align="center">${borrow.borrowBookTime}</td>
                <td align="center">${borrow.returnBookTime}</td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>