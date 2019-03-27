<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/view/common.jsp"%>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="${path}/static/js/jquery.cookie.js"></script>
    <script type="text/javascript">

      $(function(){
          var username=$.cookie("username");
          var password=$.cookie("password");
          var remember=$.cookie("remember");
          if(remember){
              $("#username").val(username);
              $("#password").val(password);
              $("#remember").prop("checked","checked");
          }
      })


      function login(){
          var username=$("#username").val();
          var password=$("#password").val();
          var checked=$("#remember").is(":checked");
          /*alert(checked);
          return;*/
          if(username=="" || password=="" ){
              alert("请填写所有信息");
              return;
          }
          $.ajax({
              url:"${path}/user?action=login",
              data:{
                  username:username,
                  password:password
              },
              type:"post",
              dataType:"json",
              success:function(result){
                  if(result.success){
                      if(checked){
                          $.cookie("username",username,{expires:7})
                          $.cookie("password",password,{expires:7})
                          $.cookie("remember",checked,{expires:7})
                      }else{
                          $.cookie("username",null)
                          $.cookie("password",null)
                          $.cookie("remember",null)
                      }
                      alert("登录成功！");
                      window.location.href="${path}/index.jsp"
                  }else{
                      $("#info").html(result.info);
                  }
              }
          })
      }
    </script>
  </head>
  <body>
  <%@include file="WEB-INF/view/header.jsp"%>
    <fieldset>
      <legend>用户登录</legend>
      <form>
        账号：<input type="text" id="username" ><br>
        密码：<input type="password" id="password" ><br>
        记住密码：<input type="checkbox" id="remember" ><br>
        <input type="button" value="登录" onclick="login()">
        <br>
        <span id="info"></span>
      </form><br>
      <a href="${path}/regist.jsp">去往注册</a>
    </fieldset>


  <h1>--------------------------------</h1>



  </body>
</html>

