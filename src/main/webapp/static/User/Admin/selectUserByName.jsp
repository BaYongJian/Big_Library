<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 12.08
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>selectUserByName</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

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
    </form>
</table>
</body>
</html>
