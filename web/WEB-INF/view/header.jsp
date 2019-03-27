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
    <c:if test="${sessionScope.username==null}">
        <a href="${path}/login1.jsp">请登录</a>&nbsp;&nbsp;&nbsp;
        <a href="${path}/register.jsp">请注册</a>
    </c:if>&nbsp;&nbsp;&nbsp;
    <c:if test="${sessionScope.username!=null}">
        欢迎您，${sessionScope.username}&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0)" onclick="logout()">退出登录</a>
    </c:if>&nbsp;&nbsp;&nbsp;
    <a href="${path}/process/car?action=query">我的购物车</a>&nbsp;&nbsp;&nbsp;
    <a href="#">我的订单</a>&nbsp;&nbsp;&nbsp;
    <a href="${path}/process/address?action=queryUserid">我的收货地址</a>&nbsp;&nbsp;&nbsp;

</body>
</html>
