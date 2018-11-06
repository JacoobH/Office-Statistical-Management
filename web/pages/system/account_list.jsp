<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/24
  Time: 7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-table.css"> -->
    <!-- 引入bootstrap样式 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入bootstrap-table样式 -->
    <link href="../../assets/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../assets/css/reset.css">
    <link rel="stylesheet" href="../../assets/css/aside.css">

</head>
<body>
<jsp:include page="../header/general_nav.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <jsp:include page="../aside/aside_function.jsp"/>
        </div>
        <div class="col-md-10">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/pages/main.jsp"/>"><span class="glyphicon glyphicon-tag"></span> 首页</a></li>
                <li><a href="#">用户管理</a></li>
            </ol>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div id="toolbar">
                        <button id="add" class="btn btn-success">
                            <i class="glyphicon glyphicon-plus"></i> 增加
                        </button>
                        <button id="remove" class="btn btn-danger" disabled>
                            <i class="glyphicon glyphicon-remove"></i> 批量删除
                        </button>
                    </div>
                    <%--弹出框--%>
                    <div class="modal fade"  id="accountModel" >
                        <div class="modal-dialog" >
                            <div class="modal-content" ></div>
                        </div>
                    </div>

                    <table id="account_table">
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer/general_footer.jsp"/>
<!-- jquery -->
<script src="../../assets/bootstrap/js/jquery-2.2.3.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
<!-- bootstrap-table.min.js -->
<script src="../../assets/bootstrap/js/bootstrap-table.min.js"></script>
<script src="../../assets/js/switch_contain.js"></script>
<script src="../../assets/js/aside.js"></script>
<script src="../../assets/js/account_list.js"></script>

<!-- 引入中文语言包 -->
<script src="../../assets/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>

</body>
</html>
