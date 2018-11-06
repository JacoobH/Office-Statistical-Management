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
    <h4 class="modal-title">${param.name}详细信息</h4>
</div>
<div class="modal-body">
    <div class="list-group">
        <a href="##" class="list-group-item">
            <h4 class="list-group-item-heading">应付租金：</h4>
            <p class="list-group-item-text">
                ${param.payment}
            </p>
        </a>
        <a href="##" class="list-group-item">
            <h4 class="list-group-item-heading">联系电话：</h4>
            <p class="list-group-item-text">致力于为中国开发者提供最全面，最具影响力，最前沿的Sass相关技术与教程...</p>
        </a>
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
</div>