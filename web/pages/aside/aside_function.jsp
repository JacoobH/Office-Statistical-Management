<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/9
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <h1>
        <span class="glyphicon glyphicon-menu-hamburger"></span> 系统管理
        <span class="color">菜单</span>
    </h1>
    <ul>
        <li>
            <a href="<c:url value="/pages/main.jsp"/>" >首页</a>
            <span class="hover"></span>
        </li>
        <c:choose>
            <c:when test="${sessionScope[\"account_power\"].equals(\"system\")}">
                <li><a href="${pageContext.request.contextPath}/pages/system/account_list.jsp">用户管理</a><span class="hover"></span></li>
                <%--<li><a href="#">用户统计</a><span class="hover"></span></li>--%>
                <li><a href="${pageContext.request.contextPath}/pages/system/online_account_list.jsp">在线用户列表</a><span class="hover"></span></li>
            </c:when>
            <c:when test="${sessionScope[\"account_power\"].equals(\"property\")}">
                <li><a href="${pageContext.request.contextPath}/pages/property/room_list.jsp">办公室信息管理</a><span class="hover"></span></li>
                <li><a href="${pageContext.request.contextPath}/pages/property/company_list.jsp">相关单位管理</a><span class="hover"></span></li>
                <li><a href="${pageContext.request.contextPath}/pages/property/statistics_info.jsp">单位统计信息</a><span class="hover"></span></li>
            </c:when>
        </c:choose>

        <li>
            <a href="#">设置</a><span class="hover"></span>
        </li>
    </ul>
</div>