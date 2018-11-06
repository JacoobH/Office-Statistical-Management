<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/7
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/reset.css">
    <link rel="stylesheet" href="../assets/css/aside.css">
    <link rel="stylesheet" href="../assets/css/carousel.css">
    <link rel="stylesheet" href="../assets/css/table.css">

</head>
<body>

<jsp:include page="header/general_nav.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <jsp:include page="aside/aside_function.jsp"/>
        </div>
        <div class="col-md-10">
            <div id="contain">
                <jsp:include page="contain/main_contain.jsp"/>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer/general_footer.jsp"/>

<script src="../assets/bootstrap/js/jquery-2.2.3.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/aside.js"></script>

</body>
</html>
