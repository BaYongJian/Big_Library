<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 12.09
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ReturnBook</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

</head>
<body>
<table class="table table-hover">
    <form method="post">
        <tr>
            <td align="center" colspan="4">
                <h1>
                    账户“${userName}”可归还书籍表
                </h1>
            </td>
        </tr>
        <tr>
            <td align="center">书籍名称</td>
            <td align="center">借阅时间</td>
            <td align="center">应还时间</td>
            <td align="center">操作</td>
        </tr>
        <c:forEach items="${borrows}" var="borrow">
            <tr>
                <td align="center">${borrow.borrowBookName}</td>
                <td align="center">${borrow.borrowBookTime}</td>
                <td align="center">${borrow.returnBookTime}</td>
                <td align="center">
                    <a href="/borrow/returnBook?userName=${userName}&bookName=${borrow.borrowBookName}" style="color: red">归还</a>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>