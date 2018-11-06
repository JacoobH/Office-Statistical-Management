<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
    <h4 class="modal-title">注册一个新办公室</h4>
</div>
<div class="modal-body">
    <form id="addForm" role="form" action="<c:url value="/action/roomDB.do?act=add"/>" method="post">
        <div class="form-group">
            <label for="room_id">
                <span class="glyphicon glyphicon-asterisk"></span>
                办公室编号
            </label>
            <input class="form-control" id="room_id"
                   type="number" name="id" autofocus="autofocus" placeholder="请输入办公室编号..."
                   required="required" max="9999">
        </div>
        <p class="text-muted">请确保办公室编号不超过4位</p>

        <div class="form-group">
            <label for="room_comName">
                <span class="glyphicon glyphicon-euro"></span>
                单位名称
            </label>
            <%--<input class="form-control" id="room_comName"--%>
                   <%--type="text" name="comName" placeholder="请输入单位名称，可为空..."--%>
                   <%--minlength="0" maxlength="20">--%>
            <div id="room_comName">
                <select class="form-control" name="comName">
                    <c:forEach var="cname" items="${applicationScope[\"company_list\"]}">
                        <option value="${cname.name}">${cname.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="room_situation">
                <span class="glyphicon glyphicon-info-sign"></span>
                租出情况
            </label>
            <div id="room_situation">
                <label>
                    <select class="form-control" name="situation">
                        <option value="false">未租出</option>
                        <option value="true">已租出</option>
                    </select>
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="room_money">
                <span class="glyphicon glyphicon-yen"></span>
                租金
            </label>
            <input class="form-control" id="room_money"
                   type="number" name="money"
                   placeholder="租金单位：人民币...">
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="submit" class="btn btn-success" form="addForm">提交</button>
</div>