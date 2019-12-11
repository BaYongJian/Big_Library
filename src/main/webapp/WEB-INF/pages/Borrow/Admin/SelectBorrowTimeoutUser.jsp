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
    <title>SelectBorrowTimeoutUser</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body>
<table class="table table-hover">
    <form method="post">
        <tr>
            <td align="center" colspan="3">
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