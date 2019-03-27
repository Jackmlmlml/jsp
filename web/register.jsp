
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/view/common.jsp"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="one/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
    <link href="one/css/dlstyle.css" rel="stylesheet" type="text/css">
    <script src="one/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="one/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
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
                        window.location.href="${path}/login1.jsp";
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

<div class="login-boxtitle">
    <a href="home2.jsp"><img alt="" src="one/images/logobig.png" /></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img src="one/images/big.jpg" /></div>
        <div class="login-box">

            <div class="am-tabs" id="doc-my-tabs">
                <ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
                    <li class="am-active"><a href="">注&nbsp; &nbsp; &nbsp;册</a></li>

                </ul>

                <div class="am-tabs-bd">
                    <div class="am-tab-panel am-active">
                        <form method="post">

                            <div class="user-email">
                                <label for="username"><i class="am-icon-envelope-o"></i></label>
                                <input type="text" id="username" placeholder="请输入账号">
                            </div>
                            <div class="user-pass">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="" id="password" placeholder="设置密码">
                            </div>
                            <div class="user-pass">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="" id="password2" placeholder="确认密码">
                            </div>

                        </form>

                        <div class="login-links">
                            <label for="reader-me">

                                <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》

                            </label>
                        </div>
                        <div class="am-cf">
                            <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl" onclick="regist()">
                            <span id="info"></span>
                        </div>

                    </div>


                    <script>
                        $(function() {
                            $('#doc-my-tabs').tabs();
                        })
                    </script>

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
                <a href="# ">关于恒望</a>
                <a href="# ">合作伙伴</a>
                <a href="# ">联系我们</a>
                <a href="# ">网站地图</a>

            </p>
        </div>
    </div>
</body>

</html>