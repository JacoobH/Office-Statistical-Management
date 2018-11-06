<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/27
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <h4 class="list-group-item-heading">开发技术：</h4>
                    <p class="list-group-item-text">
                        开发工具:<br>
                        IDE:    IntelliJ IDEA<br>
                        数据库: MySql<br>
                        语言：  Java<br>
                        框架:   bootstrap | chart.js
                    </p>
                </a>
                <a href="##" class="list-group-item">
                    <h4 class="list-group-item-heading">主要功能：</h4>
                    <p class="list-group-item-text">
                        系统管理员:  用户管理、在线用户查看<br>
                        物业公司管理员：办公室信息信息、相关单位信息管理、单位统计信息
                    </p>
                </a>
                <a href="##" class="list-group-item">
                    <h4 class="list-group-item-heading">运行环境</h4>
                    <p class="list-group-item-text">
                        操作系统：Windows10家庭中文版<br>
                        JDK版本：jdk-10.0.1<br>
                        J服务器软件：apache-tomcat-9.0.11<br>
                    </p>
                </a>
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
