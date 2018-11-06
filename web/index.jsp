<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15618
  Date: 2018/10/7
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
  <head>
      <title>管+</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="assets/css/reset.css">
      <link rel="stylesheet" href="assets/css/index.css">
  </head>
  <body>

  <jsp:include page="pages/header/general_nav.jsp" />

  <div class="container">
      <div class="row">
          <div id="info" class="col-md-5 col-md-offset-1">
              <h1 style="font-size: 60px">
                  为了办公室的<br>
                  管理者们而打造
              </h1>
              <p class="lead">
                  管+是是一个面向写字楼的办公室的统计管理平台<br>
                  在这里你可以更加便捷有效的处理各种业务<br>
                  更直观的查看各种统计数据<br>
                  最重要的是，它是免费的
              </p>
              <p><a class="btn btn-success btn-lg" href="<c:url value="nav_pages/product_introduction.jsp"/>" role="button">Learn more</a></p>

          </div>
          <div id="login_panel" class="col-md-4 col-md-offset-1 panel panel-success">
              <div class="panel-heading  text-center">
                  <b><span class="glyphicon glyphicon-pencil"></span>从这里登陆！</b>
              </div>
              <div class="panel-body">
                  <form role="form" action="action/login.do" method="post">
                      <div class="form-group">
                          <label for="user_name">
                              <span class="glyphicon glyphicon-user"></span>
                              用户名
                          </label>
                          <input class="form-control" id="user_name"
                                 type="text" name="user" autofocus="autofocus" placeholder="请输入账号"
                                 required="required" minlength="6" maxlength="10">
                      </div>
                      <div class="form-group">
                          <label for="user_password">
                              <span class="glyphicon glyphicon-lock"></span>
                              密码
                          </label>
                          <input class="form-control" id="user_password"
                                 type="password" name="ps" placeholder="请输入密码"
                                 required="required" minlength="6" maxlength="10">
                      </div>

                      <p class="text-muted">确保账户与密码都至少有6个字符，且不超过10位</p>
                      <button id="login_button" type="submit" class="btn btn-success">登陆</button>
                      <p class="text-muted">通过点击“登陆”，您同意我们的服务条款和隐私声明</p>
                  </form>
              </div>
              <div class="panel-footer">
                  <p class="text-muted text-center">不是工作人员？ <a href="#">游客登陆</a></p>
              </div>

          </div>
      </div>
  </div>

  <jsp:include page="pages/footer/general_footer.jsp"/>

  <script src="assets/js/jquery-2.2.3.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
