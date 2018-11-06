<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/25
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
    <h4 class="modal-title">修改单位信息</h4>
</div>
<div class="modal-body">
    <form id="modifyForm" role="form" action="<c:url value="/action/companyDB.do?act=modify"/>" method="post">
        <div class="form-group">
            <label for="company_name">
                <span class="glyphicon glyphicon-euro"></span>
                公司名
            </label>
            <input class="form-control" id="company_name"
                   type="text" name="name" value="${param.name}" readonly="readonly">
        </div>
        <div class="form-group">
            <label for="company_man">
                <span class="glyphicon glyphicon-user"></span>
                负责人
            </label>
            <input class="form-control" id="company_man"
                   type="text" name="man" placeholder="请输入负责人姓名..."
                   autofocus="autofocus"
                   required="required" minlength="2" maxlength="10">
        </div>
        <div class="form-group">
            <label for="company_manCardId">
                <span class="glyphicon glyphicon-credit-card"></span>
                负责人身份证号码
            </label>
            <input class="form-control" id="company_manCardId"
                   type="text" name="manCardId" placeholder="请输入负责人身份证号..."
                   required="required" minlength="18" maxlength="18">
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="submit" class="btn btn-success" form="modifyForm">提交</button>
</div>