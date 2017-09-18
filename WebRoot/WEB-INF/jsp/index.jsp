<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE HTML>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>欢迎使用SpringMVC学习系统</title>
    <link rel="stylesheet" href="<%=path %>/css/login/style.css" />
    <!-- jQuery -->
    <script type="text/javascript" src="<%=path %>/css/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript">
      $(function() {
        $("#login_submit").click(function() {
          var account = $("#account");
          var password = $("#password");
          if(account.val() == "") {
            account.focus();
            return false;
          }
          if(password.val() == "") {
            password.focus();
            return false;
          }
          $.ajax({
            url: "login.do",
            type: "POST",
            data: {
              "account": account.val(),
              "password": password.val(),
              "time": new Date().getTime()
            },
            dataType: "json",
            success: function(msg) {
              var str = JSON.stringify(msg);
              var obj = eval('('+str+')');
              var success = obj.success;
              var message = obj.message;
              if(success == true){
                location.href = "success.do";
              }else {
                $(".login").html(message);
              }
            },
            error: function(er) {
              console.log(JSON.stringify(er));
            }
          });
        });
      });
      
      function getContextPath() {

        var pathName = document.location.pathname;
        var index = pathName.substr(1).indexOf("/");
        var result = pathName.substr(0,index+1);
        return result;
    }
    </script>

  </head>

  <body>
    <div id="container">
      <form>
        <div class="login">欢迎</div>
        <div class="username-text">用户名:</div>
        <div class="password-text">密码:</div>
        <div class="username-field">
          <input type="text" name="username" id="account" value="" />
        </div>
        <div class="password-field">
          <input type="password" name="password" id="password" value="" />
        </div>
        <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住账号</label>
        <div class="forgot-usr-pwd">忘记
          <a href="#">用户名</a> 或者
          <a href="#">密码</a>?</div>
        <input type="button" name="submit" id="login_submit" value="登录" />
      </form>
    </div>
    <div id="footer">
      版权所有@Mars
    </div>
  </body>

</html>