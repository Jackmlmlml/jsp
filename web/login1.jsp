
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/view/common.jsp"%>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="two/AmazeUI-2.4.2/assets/css/amazeui.css" />
    <link href="two/css/dlstyle.css" rel="stylesheet" type="text/css">
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
                        window.location.href="${path}/hom.jsp";
                    }else{
                        $("#info").html(result.info);
                    }
                }
            })
        }
    </script>
</head>

<body>

<div class="login-boxtitle">
    <a href="home2.jsp"><img alt="logo" src="two/images/logobig.png" /></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img src="two/images/big.jpg" /></div>
        <div class="login-box">

            <h3 class="title">登录商城</h3>

            <div class="clear"></div>

            <div class="login-form">
                <form>
                    <div class="user-name">
                        <label for="username"><i class="am-icon-user"></i></label>
                        <input type="text"id="username" placeholder="邮箱/手机/用户名">
                    </div>
                    <div class="user-pass">
                        <label for="password"><i class="am-icon-lock"></i></label>
                        <input type="password" name="" id="password" placeholder="请输入密码">
                    </div>

                </form>
            </div>

            <div class="login-links">
                <label for="remember"><input id="remember" type="checkbox">记住密码</label>
                <a href="register.jsp" class="zcnext am-fr am-btn-default">注册</a>
                <br>
            </div>
            <div class="am-cf">
                <input type="button"  value="登 录"  class="am-btn am-btn-primary am-btn-sm" onclick="login()">
                <span id="info"></span>
            </div>


        </div>
    </div>
</div>


<div class="footer ">
    <div class="footer-hd ">
        <p>
            <a href="# ">恒望科技</a>
            <b>|</b>
            <a href="# ">商城首页</a>
            <b>|</b>
            <a href="# ">支付宝</a>
            <b>|</b>
            <a href="# ">物流</a>
        </p>
    </div>
    <div class="footer-bd ">
        <p>
            <a href="# ">关于巨人</a>
            <a href="# ">合作伙伴</a>
            <a href="# ">联系我们</a>
            <a href="# ">网站地图</a>
            <em>© 2015-2025 Juren.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
        </p>
    </div>
</div>
</body>

</html>