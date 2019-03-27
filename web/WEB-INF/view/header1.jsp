<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/22 0022
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function logout(){
            window.location.replace("${path}/user?action=logout");
        }
    </script>
</head>
<body>
<div class="am-container header">
    <ul class="message-l">
        <div class="topMessage">
            <div class="menu-hd">
                <a href="login1.jsp" target="_top" class="h">亲，请登录</a>
                <a href="register.jsp" target="_top">免费注册</a>
                <c:if test="${sessionScope.username!=null}">
                    欢迎您，${sessionScope.username}&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0)" onclick="logout()">退出登录</a>
                </c:if>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </ul>
    <ul class="message-r">

        <div class="topMessage my-shangcheng">
            <div class="menu-hd MyShangcheng"><a href="${path}/process/order?action=query" target="_top"><i class="am-icon-user am-icon-fw"></i>我的订单</a></div>
        </div>
        <div class="topMessage mini-cart">
            <div class="menu-hd"><a id="mc-menu-hd" href="${path}/process/car?action=query" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
        </div>

        <div class="topMessage favorite">
                <div class="menu-hd"><a href="${path}/process/area?action=queryUserid" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>我的收货地址</span></a></div>
        </div>
    </ul>
</div>
</body>
</html>