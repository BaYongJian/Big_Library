<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 12.04
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>普通用户</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <style>
        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>

</head>
<div class="col-xs-6 col-md-4 col-center-block">
    <form class="form-horizontal" method="post">
        <div class="form-group">
            <strong>
                <h1>操作列表</h1>
            </strong>
        </div>
        <div class="form-group">
            <a class="btn btn-info btn-lg active" href="/book/generalFindAll?userName=${userName}">查询书籍</a>
        </div>
        <div class="form-group">
            <a class="btn btn-info btn-lg active"
               href="/static/Book/General/selectBookByName.jsp">书名查询</a>
        </div>
        <div class="form-group">
            <a class="btn btn-warning btn-lg active" href="/borrow/findNotBorrowedBook?userName=${userName}">借阅书籍</a>
        </div>
        <div class="form-group">
            <a class="btn btn-warning btn-lg active" href="/borrow/borrowedBook?userName=${userName}">归还书籍</a>
        </div>
    </form>
</div>
</body>
</html>
