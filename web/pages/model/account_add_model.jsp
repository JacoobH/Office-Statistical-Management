<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
    <h4 class="modal-title">注册一个新用户</h4>
</div>
<div class="modal-body">
    <form id="addForm" role="form" action="<c:url value="/action/accountDB.do?act=add"/>" method="post">
        <div class="form-group">
            <label for="user_name">
                <span class="glyphicon glyphicon-user"></span>
                用户名
            </label>
            <input class="form-control" id="user_name"
                   type="text" name="user" autofocus="autofocus" placeholder="请输入账号"
                   required="required" minlength="6" maxlength="10">
        </div>
        <div class="form-group">
            <label for="user_password">
                <span class="glyphicon glyphicon-lock"></span>
                密码
            </label>
            <input class="form-control" id="user_password"
                   type="password" name="ps" placeholder="请输入密码"
                   required="required" minlength="6" maxlength="10">
        </div>
        <p class="text-muted">确保账户与密码都至少有6个字符，且不超过10位</p>
        <div class="form-group">
            <label for="user_power">
                <span class="glyphicon glyphicon-king"></span>
                权限
            </label>
            <div id="user_power">
                <label class="radio-inline">
                    <input type="radio"  value="system" name="power" checked="checked">系统管理员
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="property" name="power">物业公司管理员
                </label>
            </div>
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="submit" class="btn btn-success" form="addForm">提交</button>
</div>