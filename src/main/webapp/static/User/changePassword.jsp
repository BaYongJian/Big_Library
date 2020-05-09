<%--
  Created by IntelliJ IDEA.
  User: 巴
  Date: 05.02
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>changePassword</title>

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

<% String name = request.getParameter("userName");%>

<form class="form-horizontal" action="/user/changePassword" method="post">
    <div class="form-group">
        <div class="col-sm-4">
            <input type="hidden" class="form-control" id="inputEmail" value="<%=name%>" name="userName">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword1" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="inputPassword1" placeholder="Password" name="oldPassword">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword2" class="col-sm-2 control-label">新密码</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="inputPassword2" placeholder="Password" name="newPassword">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-3 col-sm-10">
            <button type="button" class="btn btn-success btn-lg active" data-toggle="modal"
                    data-target="#Modal" data-whatever="@mdo">修改</button>
            <div class="modal fade" id="Modal" tabindex="-1" role="dialog"
                 aria-labelledby="ModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                            <h4 class="modal-title" id="ModalLabel">确定修改？？？</h4>
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