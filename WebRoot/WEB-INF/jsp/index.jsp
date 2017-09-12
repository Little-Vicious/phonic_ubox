<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎使用SpringMVC学习系统</title>
<link rel="stylesheet" href="<%=path %>/css/login/style.css" type="text/css" />
<!-- jQuery -->
<script src="<%=path %>/css/vendor/jquery/jquery.min.js"/>

</head>
<body>
  <div id="container">
      <form action="welcome.html">
        <div class="login">欢迎</div>
        <div class="username-text">用户名:</div>
        <div class="password-text">密码:</div>
        <div class="username-field">
          <input type="text" name="username" value="" />
        </div>
        <div class="password-field">
          <input type="password" name="password" value="" />
        </div>
        <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住账号</label>
        <div class="forgot-usr-pwd">忘记 <a href="#">用户名</a> 或者 <a href="#">密码</a>?</div>
        <input type="submit" name="submit" value="登录" />
      </form>
    </div>
    <div id="footer">
      版权所有@Mars
    </div>
</body>
</html>