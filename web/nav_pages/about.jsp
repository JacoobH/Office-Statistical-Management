<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/27
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关于作者</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/reset.css">

    <style>
        body{
            background: black url("/assets/imgs/product.jpg") center;
        }
        div .panel{
            margin-top: 90px;
        }
    </style>
</head>
<body>
<div class="container">
    <jsp:include page="/pages/header/general_nav.jsp"/>
    <div class="panel panel-success">
        <div class="panel-body">
            <div class="list-group">
                <a href="##" class="list-group-item">
                    <h4 class="list-group-item-heading">作者：</h4>
                    <p class="list-group-item-text">贾宏宇</p>
                </a>
                <span href="##" class="list-group-item">
                    <h4 class="list-group-item-heading">联系方式</h4>
                    <p class="list-group-item-text">
                        <span class="glyphicon glyphicon-envelope"></span> 邮箱：<a href="#">jnoideal@gmail.com</a><br>
                        <span class="glyphicon glyphicon-pencil"></span> 博客：<a href="https://danserlesgens.blogspot.com">danserlesgens</a><br>
                        github：<a href="https://github.com/JacoobH">Henry Chia</a>
                    </p>
                </span>
            </div>
        </div>


        <div class="panel-footer">
            <a class="btn btn-success btn-lg" href="<c:url value="/pages/main.jsp"/>" role="button">返回首页</a>
        </div>
    </div>

</div>
<jsp:include page="/pages/footer/general_footer.jsp"/>
<script src="../assets/js/jquery-2.2.3.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
