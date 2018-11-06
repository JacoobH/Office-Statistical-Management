<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/27
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
                <li><a href="#">单位统计信息</a></li>
            </ol>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <canvas id="statistics-bar"></canvas>
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
<script src="../../assets/js/aside.js"></script>
<script src="../../assets/chart.js/Chart.min.js"></script>
<script src="../../assets/js/statistics_info.js"></script>
<!-- 引入中文语言包 -->
<script src="../../assets/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
</body>
</html>
