<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
    <h4 class="modal-title">注册一个新单位</h4>
</div>
<div class="modal-body">
    <form id="addForm" role="form" action="<c:url value="/action/companyDB.do?act=add"/>" method="post">
        <div class="form-group">
            <label for="company_name">
                <span class="glyphicon glyphicon-euro"></span>
                公司名
            </label>
            <input class="form-control" id="company_name"
                   type="text" name="name" autofocus="autofocus" placeholder="请输入公司名称..."
                   required="required" minlength="2" maxlength="20">
        </div>
        <div class="form-group">
            <label for="company_man">
                <span class="glyphicon glyphicon-user"></span>
                负责人
            </label>
            <input class="form-control" id="company_man"
                   type="text" name="man" placeholder="请输入负责人姓名..."
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
    <button type="submit" class="btn btn-success" form="addForm">提交</button>
</div>