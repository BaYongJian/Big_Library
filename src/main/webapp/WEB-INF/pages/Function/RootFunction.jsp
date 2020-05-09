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
    <title>管理员</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

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
        <table class="table">
            <tr>
                <td align="center">
                    <div class="form-group">
                        <strong>
                            <h1>书籍管理</h1>
                        </strong>
                    </div>
                </td>
                <td></td>
                <td align="center">
                    <div class="form-group">
                        <strong>
                            <h1>账户管理</h1>
                        </strong>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <div class="form-group">
                        <a class="btn btn-info btn-lg active" href="/book/findAll">查询书籍</a>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-info btn-lg active" href="/static/Book/Admin/selectBookByName.jsp">书名查询</a>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-danger btn-lg active" href="/static/Book/Admin/addBook.jsp">添加书籍</a>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-danger btn-lg active" href="/static/Book/Admin/deleteBook.jsp">删除书籍</a>
                    </div>
                </td>
                <td>
                    <div class="form-group">
                        <a class="btn btn-warning btn-lg active" href="/borrow/findAllBookTimeoutUser">超时未还</a>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-danger btn-lg active" href="/static/User/changePassword.jsp?userName=${userName}" role="button">修改密码</a>
                    </div>
                </td>
                <td align="center">
                    <div class="form-group">
                        <a class="btn btn-info btn-lg active" href="/user/findAll">查询账户</a>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-info btn-lg active" href="/static/User/Admin/selectUserByName.jsp">名称查询</a>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-danger btn-lg active" href="/static/User/Admin/addUser.jsp">增加账户</a>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-danger btn-lg active" href="/static/User/Admin/deleteUser.jsp">删除账户</a>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
