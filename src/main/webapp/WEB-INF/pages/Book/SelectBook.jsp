<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 12.06
  Time: 09:20
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
    <form action="/book/findByName" method="post">
        <tr>
            <div class="form-group">
                <label for="inputText1" class="col-sm-1 control-label">    </label>
                <label for="inputText1" class="col-sm-1 control-label">书籍名</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="inputText1" placeholder="书籍名" name="bookName">
                </div>
                <div class="col-sm-offset-1 col-sm-1">
                    <button type="submit" class="btn btn-success btn-lg active">查询</button>
                </div>
            </div>
        </tr>
        <tr>
            <td align="center" colspan="4">
                <h1>
                    图书馆藏书表
                </h1>
            </td>
        </tr>
        <tr>
            <td align="center">书籍名称</td>
            <td align="center">书籍作者</td>
            <td align="center">书籍总数</td>
            <td align="center">书籍剩余数</td>
            <td align="center">书籍借阅人</td>
            <td align="center">超时未归还</td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td align="center">${book.bookName}</td>
                <td align="center">${book.bookWriter}</td>
                <td align="center">${book.bookTotal}</td>
                <td align="center">${book.bookRemaining}</td>
                <td align="center">
                    <c:if test="${book.bookRemaining < book.bookTotal}" var="flag" scope="session">
                        <a href="/borrow/findByBookName?borrowBookName=${book.bookName}">点击查看</a>
                    </c:if>
                    <c:if test="${not flag}">
                        无人借阅
                    </c:if>
                </td>
                <td align="center">
                    <c:if test="${book.bookRemaining < book.bookTotal}" var="flag" scope="session">
                        <a href="#">点击查看</a>
                    </c:if>
                    <c:if test="${not flag}">
                        无人超时
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>