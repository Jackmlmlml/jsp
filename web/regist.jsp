<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/view/common.jsp"%>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
      function regist(){
          var username=$("#username").val();
          var password=$("#password").val();
          var password2=$("#password2").val();
          var phone=$("#phone").val();
          var email=$("#email").val();
          if(username=="" || password=="" || password2=="" || phone=="" || email==""){
              alert("请填写所有信息");
              return;
          }
          if(password!=password2){
              alert("两次密码输入不一致");
              return;
          }
          $.ajax({
              url:"${path}/user?action=regist",
              type:"post",
              dataType:"json",
              data:{
                  username:username,
                  password:password,
                  phone:phone,
                  email:email
              },
              success:function(result){
                  if(result.success){
                      alert("登录成功，下面将要跳向登录页面");
                      window.location.href="${path}/login.jsp";
                  }else{
                      $("#info").html(result.info);
                  }
                  console.log(result);
              }
          });
      }

    </script>
  </head>
  <body>
  <%@include file="WEB-INF/view/header.jsp"%>
    <fieldset>
      <legend>用户注册</legend>
      <form>
        账号：<input type="text" id="username"><br>
        密码：<input type="password" id="password"><br>
        重复密码：<input type="password" id="password2"><br>
        电话：<input type="text" id="phone"><br>
        邮箱：<input type="text" id="email"><br>
        <input type="button" value="注册" onclick="regist()"><br>
        <span id="info"></span>
      </form><br>
      <a href="${path}/login1.jsp">去往登录</a>
    </fieldset>

  </body>
</html>

