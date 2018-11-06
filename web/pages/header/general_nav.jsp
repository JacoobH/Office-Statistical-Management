<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/8
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        　<!-- .navbar-toggle样式用于toggle收缩的内容，即nav-collapse collapse样式所在元素 -->
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <!-- 确保无论是宽屏还是窄屏，navbar-brand都显示 -->
        <a href="<c:url value="/pages/main.jsp"/>" class="navbar-brand">OfficeBuildingManagement</a>
    </div>
    <!-- 屏幕宽度小于768px时，div.navbar-responsive-collapse容器里的内容都会隐藏，显示icon-bar图标，当点击icon-bar图标时，再展开。屏幕大于768px时，默认显示。 -->
    <div class="collapse navbar-collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li><a href="<c:url value="/nav_pages/product_introduction.jsp"/>">产品介绍</a></li>
            <li><a href="##">使用手册</a></li>
            <li><a href="<c:url value="/nav_pages/about.jsp"/>">关于</a></li>
            <li><a href="##">FAQ</a></li>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${sessionScope[\"account_user\"] != null}">
                    <a href="##" class="navbar-text">用户：${sessionScope["account_user"]}</a>
                    <li>
                        <a href="<c:url value="/action/logout.do"/>">注销</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a href="">请登录</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>