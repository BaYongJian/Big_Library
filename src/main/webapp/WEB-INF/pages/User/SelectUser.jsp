<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 12.04
  Time: 18:07
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
    <form action="/user/findByName" method="post">
        <tr>
            <div class="form-group">
                <label for="inputText1" class="col-sm-1 control-label">    </label>
                <label for="inputText1" class="col-sm-1 control-label">账号</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="inputText1" placeholder="账号" name="userName">
                </div>
                <div class="col-sm-offset-1 col-sm-1">
                    <button type="submit" class="btn btn-success btn-lg active">查询</button>
                </div>
            </div>
        </tr>
        <tr>
            <td align="center" colspan="4">
                <h1>
                    图书馆普通用户表
                </h1>
            </td>
        </tr>
        <tr>
            <td align="center">账号</td>
            <td align="center">密码</td>
            <td align="center">是否借书未还</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td align="center">${user.userName}</td>
                <td align="center">${user.password}</td>
                <td align="center">
                    <c:if test="${user.borrowBook == 0}" var="flag" scope="session">
                        否，未借书未还
                    </c:if>
                    <c:if test="${not flag}">
                        <a href="#?user_name=${user.userName}">是，点击以查看</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>
