<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 12.04
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteUser</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').focus()
        })
    </script>

</head>
<body>

    <form class="form-horizontal" action="/user/deleteUser" method="post">
        <div class="form-group"></div>
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="userName">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-10">
                <button type="button" class="btn btn-success btn-lg active" data-toggle="modal"
                        data-target="#Modal" data-whatever="@mdo">删除</button>
                <div class="modal fade" id="Modal" tabindex="-1" role="dialog"
                     aria-labelledby="ModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                                <h4 class="modal-title" id="ModalLabel">确定删除？？？</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                                <button type="submit" class="btn btn-primary" >确认</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

</body>
</html>
